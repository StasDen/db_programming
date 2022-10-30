package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.ConsultantDao;
import ua.lviv.iot.domain.Consultant;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantDaoImp implements ConsultantDao {
    public static final String FIND_ALL = "SELECT * FROM consultant";
    public static final String FIND_BY_ID = "SELECT * FROM consultant WHERE id=?";
    public static final String CREATE = "INSERT consultant(first_name, second_name, phone_number, entertainment_agency_id) VALUES (?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM consultant WHERE id=?";
    public static final String UPDATE = "UPDATE consultant SET first_name=?, second_name=?, phone_number=?, entertainment_agency_id=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Consultant> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Consultant.class));
    }

    @Override
    public Optional<Consultant> findById(Integer id) {
        Optional<Consultant> consultant;

        try {
            consultant = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Consultant.class), id));
        } catch (EmptyResultDataAccessException e) {
            consultant = Optional.empty();
        }
        return consultant;
    }

    @Override
    public int create(Consultant consultant) {
        return jdbcTemplate.update(CREATE, consultant.getFirstName(), consultant.getSecondName(), consultant.getPhoneNumber(), consultant.getEntertainmentAgencyId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, Consultant consultant) {
        return jdbcTemplate.update(UPDATE, consultant.getFirstName(), consultant.getSecondName(), consultant.getPhoneNumber(), consultant.getEntertainmentAgencyId(), id);
    }
}
