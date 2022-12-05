package io.github.joaopugliesi.featuretoggle.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_password",nullable = false)
    private String password;
    @Column(name = "created", nullable = false)
    private LocalDateTime dateCreated;
    @Column()
    private Date dateUpdate;

    public User() {

    }
    public User(Long id, String name, String password, LocalDateTime dateCreated, Date dateUpdate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dateCreated = dateCreated;
        this.dateUpdate = dateUpdate;
    }
}
