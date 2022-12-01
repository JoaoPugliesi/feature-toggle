package io.github.joaopugliesi.featuretoggle.entity;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "tb_user")
public class User implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
}
