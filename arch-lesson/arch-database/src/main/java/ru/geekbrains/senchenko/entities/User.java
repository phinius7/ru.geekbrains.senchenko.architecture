package ru.geekbrains.senchenko.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 32)
    private String userName;

    @Column(name = "password", length = 128)
    private String password;

    @Column(name = "firstname", length = 32)
    private String firstName;

    @Column(name = "lastname", length = 32)
    private String lastName;

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
