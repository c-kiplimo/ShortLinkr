package ke.natujenge.linkify.response;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class LoginVM {
    @NotNull
    private String usernameOrEmail;
    @NotNull
    private String password;

    public String getEmail() {
        return usernameOrEmail;
    }

    public void setEmail(String email) {
        this.usernameOrEmail = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVM{" +
                "usernameOrEmail='" + usernameOrEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}