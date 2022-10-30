package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Consultant;
import ua.lviv.iot.controller.ConsultantController;
import ua.lviv.iot.service.ConsultantService;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantControllerImp implements ConsultantController {
    @Autowired
    public ConsultantService consultantService;

    @Override
    public List<Consultant> findAll() {
        return consultantService.findAll();
    }

    @Override
    public Optional<Consultant> findById(Integer id) {
        return consultantService.findById(id);
    }

    @Override
    public int create(Consultant consultant) {
        return consultantService.create(consultant);
    }

    @Override
    public int delete(Integer id) {
        return consultantService.delete(id);
    }

    @Override
    public int update(Integer id, Consultant consultant) {
        return consultantService.update(id, consultant);
    }
}
