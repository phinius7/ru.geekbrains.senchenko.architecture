package ru.geekbrains.senchenko.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.geekbrains.senchenko.entities.ClientCard;
import ru.geekbrains.senchenko.repositories.datamappers.ClientCardMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientCardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ClientCard> findAll() {
        String sql = "SELECT * FROM `clients`";
        return jdbcTemplate.query(sql, new ClientCardMapper());
    }

    public Optional<ClientCard> findById(Integer id) {
        String sql = "SELECT * FROM `clients` WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id}, new ClientCardMapper()));
    }

    public void save(ClientCard clientCard) {
        String sql;
        if (clientCard.getId() == null) {
            sql = "INSERT INTO `clients` (`birthday`, `company`, `email`, `firstname`, `lastname`, `phone`) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql,
                    clientCard.getBirthday(),
                    clientCard.getCompanyName(),
                    clientCard.getEmail(),
                    clientCard.getFirstName(),
                    clientCard.getLastName(),
                    clientCard.getPhone());
        } else {
            sql = "UPDATE `clients` SET `birthday`=?, `company`=?, `email`=?, `firstname`=?, `lastname`=?, `phone`=? WHERE id = ?";
            jdbcTemplate.update(sql,
                    clientCard.getBirthday(),
                    clientCard.getCompanyName(),
                    clientCard.getEmail(),
                    clientCard.getFirstName(),
                    clientCard.getLastName(),
                    clientCard.getPhone(),
                    clientCard.getId());
        }
    }

    public void deleteById(Integer id) {
        String sql = "DELETE FROM `clients` WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
