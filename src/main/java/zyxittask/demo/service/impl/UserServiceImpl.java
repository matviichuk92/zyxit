package zyxittask.demo.service.impl;

import org.springframework.stereotype.Service;
import zyxittask.demo.model.User;
import zyxittask.demo.repository.UserRepository;
import zyxittask.demo.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
