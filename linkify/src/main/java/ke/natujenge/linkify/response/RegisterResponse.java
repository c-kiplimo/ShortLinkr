package ke.natujenge.linkify.response;

public class RegisterResponse {
    private int code = 201;

    private String description;

    public RegisterResponse(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public RegisterResponse() {
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
        return "RegisterResponse{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
