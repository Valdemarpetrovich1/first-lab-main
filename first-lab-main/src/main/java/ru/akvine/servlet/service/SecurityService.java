package ru.akvine.servlet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserService userService;

    public boolean checkAuth(String username, String password) {
        User user = userService.getByUsername(username);
        return user.getPassword().equals(password);
    }
}
