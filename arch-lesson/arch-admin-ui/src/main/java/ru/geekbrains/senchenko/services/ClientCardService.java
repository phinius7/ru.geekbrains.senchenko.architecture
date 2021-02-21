package ru.geekbrains.senchenko.services;

import ru.geekbrains.senchenko.entities.ClientCard;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ClientCardService {

    void save(ClientCard cCard) throws IOException;

    List<ClientCard> findAll();

    Optional<ClientCard> findById(Integer id);

    void delete(Integer id);
}
