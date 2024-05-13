package ke.natujenge.linkify.service;


import ke.natujenge.linkify.domain.User;
import ke.natujenge.linkify.domain.enumarations.Authority;
import ke.natujenge.linkify.domain.enumarations.IdentityProvider;
import ke.natujenge.linkify.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(String email, String username, String password){
        log.debug("Request to register user with email : {}", email);

        User registerUser = new User();
        registerUser.setEmail(email);
        registerUser.setUsername(username);
        registerUser.setPassword(passwordEncoder.encode(password));
        registerUser.setCreatedOn(String.valueOf(LocalDate.now()));
        registerUser.setCreatedBy(email);
        registerUser.setIdentityProvider(IdentityProvider.LOCAL);
        registerUser.setAuthority(Authority.MEMBER);
        userRepository.save(registerUser);
    }

    public Optional<User> findByEmail(String email){
        log.debug("Request to find user of email {}", email);
        return userRepository.findByEmail(email);
    }

    public void updateUrlCount(String username) {
        // Find the user in the database
        User existingUser = userRepository.findByUsername(username);

        // Update the count of URLs shortened by the user
        existingUser.setUrlCount(existingUser.getUrlCount() + 1);
        userRepository.save(existingUser);
    }

}
