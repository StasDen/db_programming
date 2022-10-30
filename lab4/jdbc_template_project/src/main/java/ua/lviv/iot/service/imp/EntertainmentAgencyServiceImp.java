package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.EntertainmentAgencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.service.EntertainmentAgencyService;
import ua.lviv.iot.domain.EntertainmentAgency;

import java.util.List;
import java.util.Optional;

@Service
public class EntertainmentAgencyServiceImp implements EntertainmentAgencyService {
    @Autowired
    public EntertainmentAgencyDao entertainmentAgencyDao;

    @Override
    public List<EntertainmentAgency> findAll() {
        return entertainmentAgencyDao.findAll();
    }

    @Override
    public Optional<EntertainmentAgency> findById(Integer id) {
        return entertainmentAgencyDao.findById(id);
    }

    @Override
    public int create(EntertainmentAgency entertainmentAgency) {
        return entertainmentAgencyDao.create(entertainmentAgency);
    }

    @Override
    public int delete(Integer id) {
        return entertainmentAgencyDao.delete(id);
    }

    @Override
    public int update(Integer id, EntertainmentAgency entertainmentAgency) {
        return entertainmentAgencyDao.update(id, entertainmentAgency);
    }
}
