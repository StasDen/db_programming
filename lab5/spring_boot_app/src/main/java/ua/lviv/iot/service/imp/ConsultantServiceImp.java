package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.ConsultantRepository;
import ua.lviv.iot.service.ConsultantService;
import ua.lviv.iot.domain.Consultant;
import ua.lviv.iot.exception.ConsultantNotFountException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class ConsultantServiceImp implements ConsultantService {
    @Autowired
    ConsultantRepository consultantRepository;

    public Consultant findById(Integer id) {
        return consultantRepository.findById(id).orElseThrow(() -> new ConsultantNotFountException(id));
    }

    public List<Consultant> findAll() {
        return consultantRepository.findAll();
    }

    @Transactional
    public Consultant create(Consultant consultant) {
        consultantRepository.save(consultant);
        return consultant;
    }

    @Transactional
    public void update(Integer id, Consultant uConsultant) {
        Consultant consultant = consultantRepository.findById(id).orElseThrow(() -> new ConsultantNotFountException(id));
        consultant.setFirstName(uConsultant.getFirstName());
        consultant.setSecondName(uConsultant.getSecondName());
        consultant.setPhoneNumber(uConsultant.getPhoneNumber());
        consultant.setEntertainmentAgencyId(uConsultant.getEntertainmentAgencyId());
        consultantRepository.save(consultant);
    }

    @Transactional
    public void delete(Integer id) {
        Consultant consultant = consultantRepository.findById(id).orElseThrow(() -> new ConsultantNotFountException(id));
        consultantRepository.delete(consultant);
    }

    public List<Consultant> findConsultantsByEntertainmentAgencyId(Integer id) {
        return consultantRepository.findConsultantsByEntertainmentAgencyId(id);
    }
}
