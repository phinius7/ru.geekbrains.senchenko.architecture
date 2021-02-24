package ru.geekbrains.senchenko.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 32)
    private String title;

    @Override
    public String toString() {
        return title;
    }
}
