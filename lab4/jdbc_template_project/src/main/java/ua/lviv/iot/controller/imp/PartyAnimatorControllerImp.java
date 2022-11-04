package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.PartyAnimator;
import ua.lviv.iot.service.PartyAnimatorService;
import ua.lviv.iot.controller.PartyAnimatorController;

import java.util.List;
import java.util.Optional;

@Service
public class PartyAnimatorControllerImp implements PartyAnimatorController {
    @Autowired
    public PartyAnimatorService partyAnimatorService;

    @Override
    public List<PartyAnimator> findAll() {
        return partyAnimatorService.findAll();
    }

    @Override
    public Optional<PartyAnimator> findById(Integer id) {
        return partyAnimatorService.findById(id);
    }

    @Override
    public int create(PartyAnimator partyAnimator) {
        return partyAnimatorService.create(partyAnimator);
    }

    @Override
    public int delete(Integer id) {
        return partyAnimatorService.delete(id);
    }

    @Override
    public int update(Integer id, PartyAnimator partyAnimator) {
        return partyAnimatorService.update(id, partyAnimator);
    }

    @Override
    public List<PartyAnimator> getAllUniquePerformances() {
        return partyAnimatorService.getAllUniquePerformances();
    }
}
