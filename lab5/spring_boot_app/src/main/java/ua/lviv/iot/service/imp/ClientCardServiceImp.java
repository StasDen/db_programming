package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.domain.ClientCard;
import ua.lviv.iot.repository.ClientCardRepository;
import ua.lviv.iot.service.ClientCardService;
import org.springframework.stereotype.Service;
import ua.lviv.iot.exception.ClientCardNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class ClientCardServiceImp implements ClientCardService {
    @Autowired
    ClientCardRepository clientCardRepository;

    public ClientCard findById(Integer id) {
        return clientCardRepository.findById(id).orElseThrow(() -> new ClientCardNotFoundException(id));
    }

    public List<ClientCard> findAll() {
        return clientCardRepository.findAll();
    }

    @Transactional
    public ClientCard create(ClientCard clientCard) {
        clientCardRepository.save(clientCard);
        return clientCard;
    }

    @Transactional
    public void update(Integer id, ClientCard uClientCard) {
        ClientCard clientCard = clientCardRepository.findById(id).orElseThrow(() -> new ClientCardNotFoundException((id)));
        clientCard.setName(uClientCard.getName());
        clientCard.setDiscountPercentage((uClientCard.getDiscountPercentage()));
        clientCardRepository.save(clientCard);
    }

    @Transactional
    public void delete(Integer id) {
        ClientCard clientCard = clientCardRepository.findById(id).orElseThrow(() -> new ClientCardNotFoundException((id)));
        clientCardRepository.delete(clientCard);
    }
}
