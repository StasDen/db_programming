package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.controller.CityController;
import ua.lviv.iot.service.CityService;
import ua.lviv.iot.domain.City;

import java.util.List;
import java.util.Optional;

@Service
public class CityControllerImp implements CityController {
    @Autowired
    public CityService cityService;

    @Override
    public List<City> findAll() {
        return cityService.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityService.findById(id);
    }

    @Override
    public int create(City city) {
        return cityService.create(city);
    }

    @Override
    public int delete(Integer id) {
        return cityService.delete(id);
    }

    @Override
    public int update(Integer id, City city) {
        return cityService.update(id, city);
    }
}
