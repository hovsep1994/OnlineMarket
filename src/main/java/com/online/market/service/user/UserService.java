package com.online.market.service.user;

import com.online.market.model.user.User;
import com.online.market.repository.user.UserRepository;
import com.online.market.service.exception.OnlineMarketServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User get(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new OnlineMarketServiceException("User not found")
        );
    }

    public User get(String username) {
        return userRepository.getByUsername(username).orElseThrow(() ->
                new OnlineMarketServiceException("User not found")
        );
    }

    public User create(final String username, final String password) {
        checkUnique(username);
        Assert.isTrue(password.length() >= 6, "password length >= 6");
        String encode = passwordEncoder.encode(password);
        return userRepository.save(new User(username, encode));
    }

    private void checkUnique(String username) {
        Optional<User> optional = userRepository.getByUsername(username);
        if (optional.isPresent()) {
            throw new OnlineMarketServiceException("Username is used");
        }
    }

}
