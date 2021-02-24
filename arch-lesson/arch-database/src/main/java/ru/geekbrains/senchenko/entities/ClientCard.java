package ru.geekbrains.senchenko.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname", length = 32)
    private String firstName;

    @Column(name = "lastname", length = 32)
    private String lastName;

    @Column(name = "company", length = 32)
    private String companyName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "email",length = 32)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @ManyToMany
    @JoinTable (name = "users_clients",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<User> users;
}
