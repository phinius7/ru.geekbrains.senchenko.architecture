package ru.geekbrains.senchenko.services;

import ru.geekbrains.senchenko.entities.Role;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface RoleService {

    void save(Role role) throws IOException;

    List<Role> findAll();

    Optional<Role> findById(Integer id);

    void delete(Integer id);
}
