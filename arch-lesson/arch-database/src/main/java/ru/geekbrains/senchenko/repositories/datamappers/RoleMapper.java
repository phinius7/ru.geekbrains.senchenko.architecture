package ru.geekbrains.senchenko.repositories.datamappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.senchenko.entities.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getInt("id"));
        role.setTitle(resultSet.getString("title"));
        return role;
    }
}
