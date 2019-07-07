package com.online.market.service.user;

import com.online.market.model.user.User;
import com.online.market.service.exception.OnlineMarketServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public User login(String username, String password) {
        User user = userService.get(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new OnlineMarketServiceException("Wrong password");
        }
        return user;
    }

    public void register(String username, String password) {
        userService.create(username, password);
    }
}
