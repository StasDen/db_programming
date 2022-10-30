package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.ConsultantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.service.ConsultantService;
import ua.lviv.iot.domain.Consultant;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantServiceImp implements ConsultantService {
    @Autowired
    public ConsultantDao consultantDao;

    @Override
    public List<Consultant> findAll() {
        return consultantDao.findAll();
    }

    @Override
    public Optional<Consultant> findById(Integer id) {
        return consultantDao.findById(id);
    }

    @Override
    public int create(Consultant consultant) {
        return consultantDao.create(consultant);
    }

    @Override
    public int delete(Integer id) {
        return consultantDao.delete(id);
    }

    @Override
    public int update(Integer id, Consultant consultant) {
        return consultantDao.update(id, consultant);
    }
}
