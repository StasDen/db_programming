package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.repository.CityRepository;
import ua.lviv.iot.service.CityService;
import ua.lviv.iot.exception.CityNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class CityServiceImp implements CityService {
    @Autowired
    CityRepository cityRepository;

    public City findById(Integer id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public City create(City city) {
        cityRepository.save(city);
        return city;
    }

    @Transactional
    public void update(Integer id, City uCity) {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
        city.setName(uCity.getName());
        city.setRegionId(uCity.getRegionId());
        cityRepository.save(city);
    }

    @Transactional
    public void delete(Integer id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
        cityRepository.delete(city);
    }
}
