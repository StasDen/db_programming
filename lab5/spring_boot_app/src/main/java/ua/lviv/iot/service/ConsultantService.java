package ua.lviv.iot.service;

import ua.lviv.iot.domain.Consultant;

import java.util.List;

public interface ConsultantService extends GeneralService<Consultant, Integer> {
    List<Consultant> findConsultantsByEntertainmentAgencyId(Integer id);
}
