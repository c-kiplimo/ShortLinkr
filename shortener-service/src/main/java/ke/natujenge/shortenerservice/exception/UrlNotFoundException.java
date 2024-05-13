package ke.natujenge.shortenerservice.exception;

public class UrlNotFoundException extends Throwable {
    public UrlNotFoundException(String message) {
        super(message);
    }

    public UrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
