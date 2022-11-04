package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.EntertainmentAgency;
import ua.lviv.iot.service.EntertainmentAgencyService;
import ua.lviv.iot.controller.EntertainmentAgencyController;

import java.util.List;
import java.util.Optional;

@Service
public class EntertainmentAgencyControllerImp implements EntertainmentAgencyController {
    @Autowired
    public EntertainmentAgencyService entertainmentAgencyService;

    @Override
    public List<EntertainmentAgency> findAll() {
        return entertainmentAgencyService.findAll();
    }

    @Override
    public Optional<EntertainmentAgency> findById(Integer id) {
        return entertainmentAgencyService.findById(id);
    }

    @Override
    public int create(EntertainmentAgency entertainmentAgency) {
        return entertainmentAgencyService.create(entertainmentAgency);
    }

    @Override
    public int delete(Integer id) {
        return entertainmentAgencyService.delete(id);
    }

    @Override
    public int update(Integer id, EntertainmentAgency entertainmentAgency) {
        return entertainmentAgencyService.update(id, entertainmentAgency);
    }
}
