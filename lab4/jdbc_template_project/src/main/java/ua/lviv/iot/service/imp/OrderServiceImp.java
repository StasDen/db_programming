package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.OrderDao;
import ua.lviv.iot.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    public OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderDao.findById(id);
    }

    @Override
    public int create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public int delete(Integer id) {
        return orderDao.delete(id);
    }

    @Override
    public int update(Integer id, Order order) {
        return orderDao.update(id, order);
    }
}
