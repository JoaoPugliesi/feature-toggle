package io.github.joaopugliesi.featuretoggle.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "tb_user")
public class User implements Serializable  {

    @Id
    private Long id;
}
