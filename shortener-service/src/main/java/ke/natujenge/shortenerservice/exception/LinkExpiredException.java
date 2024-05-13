package ke.natujenge.shortenerservice.exception;

public class LinkExpiredException extends Throwable {
    public LinkExpiredException(String message) {
        super(message);
    }

    public LinkExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
