package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.EntertainmentAgencyRepository;
import ua.lviv.iot.service.EntertainmentAgencyService;
import ua.lviv.iot.domain.EntertainmentAgency;
import ua.lviv.iot.exception.EntertainmentAgencyNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class EntertainmentAgencyServiceImp implements EntertainmentAgencyService {
    @Autowired
    EntertainmentAgencyRepository entertainmentAgencyRepository;

    public EntertainmentAgency findById(Integer id) {
        return entertainmentAgencyRepository.findById(id).orElseThrow(() -> new EntertainmentAgencyNotFoundException(id));
    }

    public List<EntertainmentAgency> findAll() {
        return entertainmentAgencyRepository.findAll();
    }

    @Transactional
    public EntertainmentAgency create(EntertainmentAgency entertainmentAgency) {
        entertainmentAgencyRepository.save(entertainmentAgency);
        return entertainmentAgency;
    }

    @Transactional
    public void update(Integer id, EntertainmentAgency uEntertainmentAgency) {
        EntertainmentAgency entertainmentAgency = entertainmentAgencyRepository.findById(id).orElseThrow(() -> new EntertainmentAgencyNotFoundException(id));
        entertainmentAgency.setName(uEntertainmentAgency.getName());
        entertainmentAgency.setContactNumber(uEntertainmentAgency.getContactNumber());
        entertainmentAgency.setAddress(uEntertainmentAgency.getAddress());
        entertainmentAgency.setAnimatorId(uEntertainmentAgency.getAnimatorId());
        entertainmentAgency.setCityId(uEntertainmentAgency.getCityId());
        entertainmentAgencyRepository.save(entertainmentAgency);
    }

    @Transactional
    public void delete(Integer id) {
        EntertainmentAgency entertainmentAgency = entertainmentAgencyRepository.findById(id).orElseThrow(() -> new EntertainmentAgencyNotFoundException(id));
        entertainmentAgencyRepository.delete(entertainmentAgency);
    }

    public List<EntertainmentAgency> findAllEntertainmentAgenciesByCityId(Integer id) {
        return entertainmentAgencyRepository.findAllEntertainmentAgenciesByCityId(id);
    }
}
