package ru.akvine.servlet.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.akvine.servlet.models.UserEntity;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String phone;
    private String email;

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.role = userEntity.getRole();
        this.phone = userEntity.getPhone();
        this.email = userEntity.getEmail();
    }
}
