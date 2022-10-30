package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    public ClientDao clientDao;

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientDao.findById(id);
    }

    @Override
    public int create(Client client) {
        return clientDao.create(client);
    }

    @Override
    public int delete(Integer id) {
        return clientDao.delete(id);
    }

    @Override
    public int update(Integer id, Client client) {
        return clientDao.update(id, client);
    }
}
