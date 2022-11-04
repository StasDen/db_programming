package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.controller.ClientCardController;
import ua.lviv.iot.domain.ClientCard;
import ua.lviv.iot.service.ClientCardService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientCardControllerImp implements ClientCardController {
    @Autowired
    public ClientCardService clientCardService;

    @Override
    public List<ClientCard> findAll() {
        return clientCardService.findAll();
    }

    @Override
    public Optional<ClientCard> findById(Integer id) {
        return clientCardService.findById(id);
    }

    @Override
    public int create(ClientCard clientCard) {
        return clientCardService.create(clientCard);
    }

    @Override
    public int delete(Integer id) {
        return clientCardService.delete(id);
    }

    @Override
    public int update(Integer id, ClientCard clientCard) {
        return clientCardService.update(id, clientCard);
    }
}
