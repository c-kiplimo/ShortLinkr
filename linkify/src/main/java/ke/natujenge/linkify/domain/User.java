package ke.natujenge.linkify.domain;


import ke.natujenge.linkify.domain.enumarations.Authority;
import ke.natujenge.linkify.domain.enumarations.IdentityProvider;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String password;
    private String createdOn;

    private String createdBy;
    private Integer urlCount;

    @Enumerated(EnumType.STRING)
    private IdentityProvider identityProvider;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public String getAuthorityName(){
        if (this.authority != null){
            return authority.name();
        }
        return "";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", identityProvider=" + identityProvider +
                ", authority=" + authority +
                '}';
    }
}
