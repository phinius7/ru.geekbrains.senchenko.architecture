package ru.geekbrains.senchenko.repositories.datamappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.geekbrains.senchenko.entities.ClientCard;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientCardMapper implements RowMapper<ClientCard> {

    @Override
    public ClientCard mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientCard clientCard = new ClientCard();
        clientCard.setId(resultSet.getInt("id"));
        clientCard.setBirthday(resultSet.getDate("birthday"));
        clientCard.setCompanyName(resultSet.getString("company"));
        clientCard.setEmail(resultSet.getString("email"));
        clientCard.setFirstName(resultSet.getString("firstname"));
        clientCard.setLastName(resultSet.getString("lastname"));
        clientCard.setPhone(resultSet.getString("phone"));
        return clientCard;
    }
}
