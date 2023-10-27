package ru.akvine.servlet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private String role;
    private String phone;
    private String email;
}
