package zyxit.task.service;

import zyxit.task.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByName(String name);
}
