package ru.geekbrains.senchenko.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.geekbrains.senchenko.entities.User;
import ru.geekbrains.senchenko.repositories.datamappers.UserMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String sql = "SELECT * FROM `users`";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public Optional<User> findById(Integer id) {
        String sql = "SELECT * FROM `users` WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper()));
    }

    public void save(User user) {
        String sql;
        if (user.getId() == null) {
            sql = "INSERT INTO `users` (`birthday`, `email`, `firstname`, `lastname`, `password`, `phone`, `username`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql,
                    user.getBirthday(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPassword(),
                    user.getPhone(),
                    user.getUserName());
        } else {
            sql = "UPDATE `users` SET `birthday`=?, `email`=?, `firstname`=?, `lastname`=?, `password`=?, `phone`=?, `username`=? WHERE id=?";
            jdbcTemplate.update(sql,
                    user.getBirthday(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPassword(),
                    user.getPhone(),
                    user.getUserName(),
                    user.getId());
        }
    }

    public void deleteById(Integer id) {
        String sql = "DELETE FROM `users` WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
