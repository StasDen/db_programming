package ua.lviv.iot.service;

import ua.lviv.iot.domain.PartyAnimatorCopy;

import java.util.List;

public interface PartyAnimatorCopyService {
    PartyAnimatorCopy findById(Integer id);

    List<PartyAnimatorCopy> findAll();
}
