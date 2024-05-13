package ke.natujenge.linkify.web.rest;

import ke.natujenge.linkify.domain.User;
import ke.natujenge.linkify.domain.enumarations.IdentityProvider;
import ke.natujenge.linkify.response.JwtResponse;
import ke.natujenge.linkify.response.LoginVM;
import ke.natujenge.linkify.response.RegisterResponse;
import ke.natujenge.linkify.response.RegisterVM;
import ke.natujenge.linkify.security.IdentityProviderException;
import ke.natujenge.linkify.security.jwt.LinkifyAuthenticationManager;
import ke.natujenge.linkify.security.jwt.TokenProvider;
import ke.natujenge.linkify.service.UserService;
import ke.natujenge.linkify.util.GmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@Slf4j
@RestController
@RequestMapping("/api")
public class RegisterResource {

    @Autowired
    private final UserService registerService;

    @Autowired
    private final TokenProvider tokenProvider;
    @Autowired
    private final LinkifyAuthenticationManager authenticationManager;

    public RegisterResource(UserService userService, TokenProvider tokenProvider, LinkifyAuthenticationManager authenticationManager) {
        this.registerService = userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterVM registerUser) {
        String normalizedEmail = GmailUtil.normalizeEmail(registerUser.getEmail());
        Optional<User> registerUserOptional = registerService.findByEmail(normalizedEmail);

        if (registerUserOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RegisterResponse(400, "email address already used"));
        }

        try {
            this.registerService.registerUser(normalizedEmail, registerUser.getUsername(), registerUser.getPassword());
            return ResponseEntity.ok().body(new RegisterResponse(200, "Account successfully created"));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RegisterResponse(500, "Error creating user"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authorize(@RequestBody LoginVM loginVM) {
        String normalizedEmail = GmailUtil.normalizeEmail(loginVM.getEmail());
        User authenticationDetails = authenticationManager.authenticateAndReturnUser(new UsernamePasswordAuthenticationToken(
                normalizedEmail,
                loginVM.getPassword()));
        try {
       long expiryTime = 86400 + (System.currentTimeMillis() / 1000);
           String jwtToken = tokenProvider.createToken(normalizedEmail, IdentityProvider.LOCAL, expiryTime, authenticationDetails.getAuthorityName());
           String authority = authenticationDetails.getAuthorityName();
          return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(jwtToken,authority));

        } catch (IdentityProviderException exception) {
            log.warn("Error authenticating user", exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JwtResponse(400, "Please log in with google"));
        } catch (AuthenticationException exception) {
            log.warn("Error authenticating user", exception);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse(401, "invalid username or password"));
        }
    }

    private boolean isPasswordLengthInvalid(String password) {
        return (
                StringUtils.isEmpty(password) ||
                        password.length() < 4 ||
                        password.length() > 100
        );
    }
    @PutMapping("/urls/count")
    public void updateUrlCount(@AuthenticationPrincipal User user) {
        registerService.updateUrlCount(user.getUsername());
    }

}


