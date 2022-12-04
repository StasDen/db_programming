package ua.lviv.iot.service;

import ua.lviv.iot.domain.Client;

public interface ClientService extends GeneralService<Client, Integer> {
    Client addOrderingForClient(Integer clientId, Integer orderingId);

    Client removeOrderingForClient(Integer clientId, Integer orderingId);
}
