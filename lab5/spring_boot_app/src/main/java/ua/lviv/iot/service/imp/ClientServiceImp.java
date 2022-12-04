package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.Ordering;
import ua.lviv.iot.exception.OrderingNotFoundException;
import ua.lviv.iot.repository.ClientRepository;
import ua.lviv.iot.repository.OrderingRepository;
import ua.lviv.iot.service.ClientService;
import org.springframework.stereotype.Service;
import ua.lviv.iot.exception.ClientNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderingRepository orderingRepository;

    public Client findById(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client create(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public void update(Integer id, Client uClient) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        client.setFirstName(uClient.getFirstName());
        client.setSecondName(uClient.getSecondName());
        client.setPhoneNumber(uClient.getPhoneNumber());
        client.setClientCardId(uClient.getClientCardId());
        clientRepository.save(client);
    }

    @Transactional
    public void delete(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        clientRepository.delete(client);
    }

    @Transactional
    public Client addOrderingForClient(Integer clientId, Integer orderingId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        Ordering ordering = orderingRepository.findById(orderingId).orElseThrow(() -> new OrderingNotFoundException(orderingId));
        client.getOrderings().add(ordering);
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public Client removeOrderingForClient(Integer clientId, Integer orderingId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        Ordering ordering = orderingRepository.findById(orderingId).orElseThrow(() -> new OrderingNotFoundException(orderingId));
        client.getOrderings().remove(ordering);
        clientRepository.save(client);
        return client;
    }
}
