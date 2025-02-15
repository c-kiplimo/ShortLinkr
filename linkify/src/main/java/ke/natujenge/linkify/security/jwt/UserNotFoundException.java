package ke.natujenge.linkify.security.jwt;

import org.springframework.security.core.AuthenticationException;

    public class UserNotFoundException extends AuthenticationException {

        public UserNotFoundException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public UserNotFoundException(String msg) {
            super(msg);
        }
    }

