package ke.natujenge.linkify.security.jwt;

import ke.natujenge.linkify.domain.User;
import ke.natujenge.linkify.security.LinkifyAuthority;
import ke.natujenge.linkify.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class LinkifyAuthenticationManager implements AuthenticationManager {


    private final UserService userService;

    private  final PasswordEncoder passwordEncoder;

    public LinkifyAuthenticationManager(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        Optional<User> optionalUser = userService.findByEmail(username);

        // check if user exists
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Username not registered");
        }

        User user = optionalUser.get();

        if (password.isEmpty() || !passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid Credentials");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new LinkifyAuthority(user.getAuthorityName()));


        return new CustomAuthentication(grantedAuthorities, null, username, true, user.getEmail(), user.getIdentityProvider());
    }
    public User authenticateAndReturnUser(Authentication authentication) throws AuthenticationException {

        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        Optional<User> optionalUser = userService.findByEmail(username);

        // check if user exists
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Username not registered");
        }

        User registerUser = optionalUser.get();

        if (password.isEmpty() || !passwordEncoder.matches(password, registerUser.getPassword())) {
            throw new BadCredentialsException("Invalid Credentials");
        }

        return registerUser;
    }

    
}
