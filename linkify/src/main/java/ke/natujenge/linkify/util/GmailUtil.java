package ke.natujenge.linkify.util;

import java.util.Objects;

public class GmailUtil {
    public static String normalizeEmail(String email) {
        Objects.requireNonNull(email);

        // lowercase
        email = email.toLowerCase();


        if (email.contains("@")) {
            String[] mailParts = email.split("@");
            if (email.endsWith("@gmail.com")) {
                email = mailParts[0].replaceAll("\\.", "") + "@" + mailParts[1];
            }
        }

        return email;
    }
}
