package ru.geekbrains.senchenko.repositories;

import ru.geekbrains.senchenko.entities.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Integer> {
}
