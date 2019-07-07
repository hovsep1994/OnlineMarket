package com.online.market.repository.user;

import com.online.market.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> getByUsername(String username);

}
