package ru.geekbrains.senchenko.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.geekbrains.senchenko.entities.Role;
import ru.geekbrains.senchenko.repositories.datamappers.RoleMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        String sql = "SELECT * FROM `roles`";
        return jdbcTemplate.query(sql, new RoleMapper());
    }

    public Optional<Role> findById(Integer id) {
        String sql = "SELECT * FROM `roles` WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id}, new RoleMapper()));
    }

    public void save(Role role) {
        String sql;
        if (role.getId() == null) {
            sql = "INSERT INTO `roles` (`title`) VALUES (?)";
            jdbcTemplate.update(sql, role.getTitle());
        } else {
            sql = "UPDATE `roles` SET `title`=? WHERE id=?";
            jdbcTemplate.update(sql, role.getTitle(), role.getId());
        }
    }

    public void deleteById(Integer id) {
        String sql = "DELETE FROM `roles` WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
