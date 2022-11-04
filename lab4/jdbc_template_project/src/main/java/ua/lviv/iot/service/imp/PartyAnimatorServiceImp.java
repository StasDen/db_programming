package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.PartyAnimatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.PartyAnimator;
import ua.lviv.iot.service.PartyAnimatorService;

import java.util.List;
import java.util.Optional;

@Service
public class PartyAnimatorServiceImp implements PartyAnimatorService {
    @Autowired
    public PartyAnimatorDao partyAnimatorDao;

    @Override
    public List<PartyAnimator> findAll() {
        return partyAnimatorDao.findAll();
    }

    @Override
    public Optional<PartyAnimator> findById(Integer id) {
        return partyAnimatorDao.findById(id);
    }

    @Override
    public int create(PartyAnimator partyAnimator) {
        return partyAnimatorDao.create(partyAnimator);
    }

    @Override
    public int delete(Integer id) {
        return partyAnimatorDao.delete(id);
    }

    @Override
    public int update(Integer id, PartyAnimator partyAnimator) {
        return partyAnimatorDao.update(id, partyAnimator);
    }

    @Override
    public List<PartyAnimator> getAllUniquePerformances() {
        return partyAnimatorDao.getAllUniquePerformances();
    }
}
