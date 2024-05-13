package ke.natujenge.linkify.security;

import org.springframework.security.core.GrantedAuthority;

public class LinkifyAuthority implements GrantedAuthority {
    private String authority;

    public LinkifyAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "LinkifyAuthority{" +
                "authority='" + authority + '\'' +
                '}';
    }
}
