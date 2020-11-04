package zyxittask.demo.service;

import zyxittask.demo.model.User;

import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByName(String name);
}
