package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.ClientCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ClientCard;
import ua.lviv.iot.service.ClientCardService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientCardServiceImp implements ClientCardService {
    @Autowired
    public ClientCardDao clientCardDao;

    @Override
    public List<ClientCard> findAll() {
        return clientCardDao.findAll();
    }

    @Override
    public Optional<ClientCard> findById(Integer id) {
        return clientCardDao.findById(id);
    }

    @Override
    public int update(Integer id, ClientCard clientCard) {
        return clientCardDao.update(id, clientCard);
    }

    @Override
    public int create(ClientCard clientCard) {
        return clientCardDao.create(clientCard);
    }

    @Override
    public int delete(Integer id) {
        return clientCardDao.delete(id);
    }
}
