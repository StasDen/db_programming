package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.service.ClientService;
import ua.lviv.iot.controller.ClientController;

import java.util.List;
import java.util.Optional;

@Service
public class ClientControllerImp implements ClientController {
    @Autowired
    public ClientService clientService;

    @Override
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public int create(Client client) {
        return clientService.create(client);
    }

    @Override
    public int delete(Integer id) {
        return clientService.delete(id);
    }

    @Override
    public int update(Integer id, Client client) {
        return clientService.update(id, client);
    }
}
