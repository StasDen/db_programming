package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.ClientDao;
import ua.lviv.iot.domain.Client;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ClientDaoImp implements ClientDao {
    public static final String FIND_ALL = "SELECT * FROM client";
    public static final String FIND_DY_ID = "SELECT * FROM client WHERE id=?";
    public static final String CREATE = "INSERT client(first_name, second_name, phone_number, client_card_id) VALUES (?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM client WHERE id=?";
    public static final String UPDATE = "UPDATE client SET first_name=?, second_name=?, phone_number=?, client_card_id=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Client.class));
    }

    @Override
    public Optional<Client> findById(Integer id) {
        Optional<Client> client;

        try {
            client = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_DY_ID, BeanPropertyRowMapper.newInstance(Client.class), id));
        } catch (EmptyResultDataAccessException e) {
            client = Optional.empty();
        }
        return client;
    }

    @Override
    public int create(Client client) {
        return jdbcTemplate.update(CREATE, client.getFirstName(), client.getSecondName(), client.getPhoneNumber(), client.getClientCardId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, Client client) {
        return jdbcTemplate.update(UPDATE, client.getFirstName(), client.getSecondName(), client.getPhoneNumber(), client.getClientCardId(), id);
    }
}
