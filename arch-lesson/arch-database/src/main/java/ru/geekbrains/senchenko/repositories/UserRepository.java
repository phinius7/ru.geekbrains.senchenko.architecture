package ru.geekbrains.senchenko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.senchenko.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
