package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.PartyAnimatorCopy;
import ua.lviv.iot.repository.PartyAnimatorCopyRepository;
import ua.lviv.iot.service.PartyAnimatorCopyService;
import ua.lviv.iot.exception.AnimLogNotFoundException;

import java.util.List;

@Service
public class PartyAnimatorCopyServiceImp implements PartyAnimatorCopyService {
    @Autowired
    PartyAnimatorCopyRepository partyAnimatorCopyRepository;

    @Override
    public PartyAnimatorCopy findById(Integer id) {
        return partyAnimatorCopyRepository.findById(id).orElseThrow(() -> new AnimLogNotFoundException(id));
    }

    @Override
    public List<PartyAnimatorCopy> findAll() {
        return partyAnimatorCopyRepository.findAll();
    }
}
