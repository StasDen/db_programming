package ua.lviv.iot.dao;

import ua.lviv.iot.domain.ClientCard;

import java.util.Optional;

public interface ClientCardDao extends GeneralDao<ClientCard, Integer> {
    // Optional<ClientCard> findByClientCardId(Integer Id);
}
