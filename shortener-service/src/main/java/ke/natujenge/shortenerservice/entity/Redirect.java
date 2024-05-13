//package ke.natujenge.shortenerservice.entity;
//
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.sun.istack.NotNull;
//import jdk.jfr.DataAmount;
//import org.hibernate.annotations.NaturalId;
//import lombok.*;
//import javax.persistence.*;
//
//@Data
//@Getter
//@AllArgsConstructor
//@Setter
//@Entity
//@Table(name="shortener_table")
//public class Redirect {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    @Column(name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "default")
//    @JsonIgnore
//    private Long id;
//
//    @NaturalId
//    @Column(name="redirect", unique=true, nullable=false)
//    private String redirect;
//
//    @Column(name="url", nullable = false)
//    private String url;
//
//    public Redirect(final String redirect, final String url) {
//        this.redirect = redirect;
//        this.url = url;
//    }
//
//    public Redirect(){
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRedirect() {
//        return redirect;
//    }
//
//    public void setRedirect(String redirect) {
//        this.redirect = redirect;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @Override
//    public String toString() {
//        return "Redirect{" +
//                "id=" + id +
//                ", redirect='" + redirect + '\'' +
//                ", url='" + url + '\'' +
//                '}';
//    }
//}
