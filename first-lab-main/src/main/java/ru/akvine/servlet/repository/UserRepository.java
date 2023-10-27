package ru.akvine.servlet.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akvine.servlet.models.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class UserRepository {
    private List<UserEntity> users = Stream.of(
            new UserEntity(1, "admin", "123456", "ADMIN", "9800305067", "test@email.com")
            ,new UserEntity(2, "super_user", "123456", "SUPER_USER", "9800305067", "test@email.com")
                    ,new UserEntity(3, "user", "1234", "USER", "9800305067", "test@email.com"))
            .collect(Collectors.toList());

    public UserEntity save(UserEntity userEntity) {
        userEntity.setId(users.size() + 1);
        users.add(userEntity);
        return userEntity;
    }

    public Optional<UserEntity> findById(int id) {
        if (id > users.size() || id < 0) {
            return Optional.empty();
        }

        return Optional.of(users.get(id));
    }

    public List<UserEntity> findAll() {
        return users;
    }
}
