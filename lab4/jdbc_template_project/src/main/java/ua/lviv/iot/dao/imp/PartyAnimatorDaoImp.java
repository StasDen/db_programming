package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.PartyAnimatorDao;
import ua.lviv.iot.domain.PartyAnimator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class PartyAnimatorDaoImp implements PartyAnimatorDao {
    public static final String FIND_ALL = "SELECT * FROM party_animator";
    public static final String FIND_BY_ID = "SELECT * FROM party_animator WHERE id =?";
    public static final String CREATE = "INSERT party_animator(first_name, last_name, phone_number, unique_performance, work_experience_in_years, order_id) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM party_animator WHERE id=?";
    public static final String UPDATE = "UPDATE party_animator SET first_name=?, last_name=?, phone_number=?, unique_performance=?, work_experience_in_years=?, order_id=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<PartyAnimator> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(PartyAnimator.class));
    }

    @Override
    public Optional<PartyAnimator> findById(Integer id) {
        Optional<PartyAnimator> partyAnimator;

        try {
            partyAnimator = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(PartyAnimator.class), id));
        } catch (EmptyResultDataAccessException e) {
            partyAnimator = Optional.empty();
        }
        return partyAnimator;
    }

    @Override
    public int create(PartyAnimator partyAnimator) {
        return jdbcTemplate.update(CREATE, partyAnimator.getFirstName(), partyAnimator.getLastName(), partyAnimator.getPhoneNumber(), partyAnimator.getUniquePerformance(), partyAnimator.getWorkExperienceInYears(), partyAnimator.getOrderId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, PartyAnimator partyAnimator) {
        return jdbcTemplate.update(UPDATE, partyAnimator.getFirstName(), partyAnimator.getLastName(), partyAnimator.getPhoneNumber(), partyAnimator.getUniquePerformance(), partyAnimator.getWorkExperienceInYears(), partyAnimator.getOrderId(), id);
    }
}
