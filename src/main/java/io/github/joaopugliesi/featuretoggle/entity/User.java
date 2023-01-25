package io.github.joaopugliesi.featuretoggle.entity;


import io.github.joaopugliesi.featuretoggle.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "created", nullable = false)
    private LocalDateTime dateCreated;
    @Column()
    private LocalDateTime dateUpdate;

//    public static User fromDto(UserDto dto) {
//        private String name;
//        return User.builder().build();
//    }
}
