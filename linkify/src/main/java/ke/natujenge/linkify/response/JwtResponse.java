package ke.natujenge.linkify.response;

public class JwtResponse {
    private String bearerToken;

    private String authority;

    private int code;

    private String description;

    public JwtResponse(String bearerToken, String authority) {
        this.bearerToken = bearerToken;
        this.authority = authority;
        this.code = 200;
        this.description = "successful";
    }

    public JwtResponse(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public JwtResponse(){}

    public String getBearerToken() {
        return bearerToken;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "bearerToken='" + bearerToken + '\'' +
                ", authority='" + authority + '\'' +
                ", code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
