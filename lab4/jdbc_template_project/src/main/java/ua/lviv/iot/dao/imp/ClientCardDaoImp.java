package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ClientCard;
import ua.lviv.iot.dao.ClientCardDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientCardDaoImp implements ClientCardDao {
    public static final String FIND_ALL = "SELECT * FROM client_card";
    public static final String FIND_DY_ID = "SELECT * FROM client_card WHERE id=?";
    public static final String CREATE = "INSERT client_card(name, discount_percentage) VALUES (?, ?)";
    public static final String DELETE = "DELETE FROM client_card WHERE id=?";
    public static final String UPDATE = "UPDATE client_card SET name=?, discount_percentage=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<ClientCard> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ClientCard.class));
    }

    @Override
    public Optional<ClientCard> findById(Integer id) {
        Optional<ClientCard> clientCard;

        try {
            clientCard = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_DY_ID, BeanPropertyRowMapper.newInstance(ClientCard.class), id));
        } catch (EmptyResultDataAccessException e) {
            clientCard = Optional.empty();
        }
        return clientCard;
    }

    @Override
    public int create(ClientCard clientCard) {
        return jdbcTemplate.update(CREATE, clientCard.getName(), clientCard.getDiscountPercentage());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, ClientCard clientCard) {
        return jdbcTemplate.update(UPDATE, clientCard.getName(), clientCard.getDiscountPercentage(), id);
    }
}
