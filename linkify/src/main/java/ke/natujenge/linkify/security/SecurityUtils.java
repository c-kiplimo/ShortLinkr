package ke.natujenge.linkify.security;

import ke.natujenge.linkify.security.jwt.CustomAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtils {
    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails) {
                        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                        return springSecurityUser.getUsername();
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                });
    }

    public static Optional<String> getCurrentUserLogin2() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (securityContext.getAuthentication() != null) {
            return Optional.ofNullable(securityContext.getAuthentication().getName());
        }
        return Optional.empty();
    }


    public static Optional<String> getCurrentUseEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(authentication.getName());
    }

    /**
     * Get the JWT of the current user.
     *
     * @return the JWT of the current user
     */
    public static Optional<String> getCurrentUserJWT() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .filter(authentication -> authentication.getCredentials() instanceof String)
                .map(authentication -> (String) authentication.getCredentials());
    }

    /**
     * Check if a user is authenticated.
     *
     * @return true if the user is authenticated, false otherwise
     */
    public static boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).isPresent();
    }

    /**
     * If the current user has a specific authority (security role).
     * <p>
     * The name of this method comes from the isUserInRole() method in the Servlet API
     *
     * @param authority the authority to check
     * @return true if the current user has the authority, false otherwise
     */
    public static boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
                .orElse(false);
    }

    public static Optional<CustomAuthentication> getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication = context.getAuthentication();
        if (authentication != null) {
            if (authentication instanceof CustomAuthentication) {
                return Optional.of((CustomAuthentication) authentication);
            }
        }
        return Optional.empty();
    }

    public static String getBearer() {
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication = context.getAuthentication();
        if (authentication != null) {
            if (authentication instanceof CustomAuthentication && ((CustomAuthentication) authentication).getBearerToken() != null) {
                return "Bearer " + ((CustomAuthentication) authentication).getBearerToken();
            }
        }
        return null;
    }
}
