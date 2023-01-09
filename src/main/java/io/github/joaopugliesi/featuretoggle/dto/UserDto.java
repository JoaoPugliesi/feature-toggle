package io.github.joaopugliesi.featuretoggle.dto;

import io.github.joaopugliesi.featuretoggle.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String password;

    public UserDto(User entity) {
        this.name = entity.getName();
        this.password = entity.getPassword();
    }
}
