package ua.lviv.iot.service;

import ua.lviv.iot.domain.EntertainmentAgency;

import java.util.List;

public interface EntertainmentAgencyService extends GeneralService<EntertainmentAgency, Integer> {
    List<EntertainmentAgency> findAllEntertainmentAgenciesByCityId(Integer id);
}
