package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.PartyAnimatorRepository;
import ua.lviv.iot.service.PartyAnimatorService;
import ua.lviv.iot.domain.PartyAnimator;
import ua.lviv.iot.exception.PartyAnimatorNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class PartyAnimatorServiceImp implements PartyAnimatorService {
    @Autowired
    PartyAnimatorRepository partyAnimatorRepository;

    public PartyAnimator findById(Integer id) {
        return partyAnimatorRepository.findById(id).orElseThrow(() -> new PartyAnimatorNotFoundException(id));
    }

    public List<PartyAnimator> findAll() {
        return partyAnimatorRepository.findAll();
    }

    @Transactional
    public PartyAnimator create(PartyAnimator partyAnimator) {
        partyAnimatorRepository.save(partyAnimator);
        return partyAnimator;
    }

    @Transactional
    public void update(Integer id, PartyAnimator uPartyAnimator) {
        PartyAnimator partyAnimator = partyAnimatorRepository.findById(id).orElseThrow(() -> new PartyAnimatorNotFoundException(id));
        partyAnimator.setFirstName(uPartyAnimator.getFirstName());
        partyAnimator.setSecondName(uPartyAnimator.getSecondName());
        partyAnimator.setPhoneNumber(uPartyAnimator.getPhoneNumber());
        partyAnimator.setUniquePerformance(uPartyAnimator.getUniquePerformance());
        partyAnimator.setWorkExperienceInYears(uPartyAnimator.getWorkExperienceInYears());
        partyAnimator.setOrderId(uPartyAnimator.getOrderId());
        partyAnimatorRepository.save(partyAnimator);
    }

    @Transactional
    public void delete(Integer id) {
        PartyAnimator partyAnimator = partyAnimatorRepository.findById(id).orElseThrow(() -> new PartyAnimatorNotFoundException(id));
        partyAnimatorRepository.delete(partyAnimator);
    }

    public List<PartyAnimator> findPartyAnimatorsWithUniquePerformances() {
        return partyAnimatorRepository.findPartyAnimatorsWithUniquePerformances();
    }
}
