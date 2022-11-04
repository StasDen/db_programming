package ua.lviv.iot.controller;

import ua.lviv.iot.domain.PartyAnimator;

import java.util.List;

public interface PartyAnimatorController extends GeneralController<PartyAnimator, Integer> {
    List<PartyAnimator> getAllUniquePerformances();
}
