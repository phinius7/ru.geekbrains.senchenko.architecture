package ru.geekbrains.senchenko.services;

import ru.geekbrains.senchenko.entities.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user) throws IOException;

    List<User> findAll();

    Optional<User> findById(Integer id);

    void delete(Integer id);
}
