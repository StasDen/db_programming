package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Order;
import ua.lviv.iot.service.OrderService;
import ua.lviv.iot.controller.OrderController;

import java.util.List;
import java.util.Optional;

@Service
public class OrderControllerImp implements OrderController {
    @Autowired
    public OrderService orderService;

    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderService.findById(id);
    }

    @Override
    public int create(Order order) {
        return orderService.create(order);
    }

    @Override
    public int delete(Integer id) {
        return orderService.delete(id);
    }

    @Override
    public int update(Integer id, Order order) {
        return orderService.update(id, order);
    }

    @Override
    public List<Order> getVipOrders() {
        return orderService.getVipOrders();
    }
}
