package ru.akvine.servlet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.servlet.models.UserEntity;
import ru.akvine.servlet.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getById(int id) {
        return new User(userRepository.findById(id).get());
    }

    public List<User> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public void save(User user) {
        UserEntity userEntityToSave = new UserEntity()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setPhone(user.getPhone())
                .setRole(user.getRole())
                .setEmail(user.getEmail());

        new User(userRepository.save(userEntityToSave));
    }

    public User getByUsername(String username) {
        List<User> users = getAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        throw new RuntimeException("Not found by username=" + username);
    }

}
