package ua.lviv.iot.service;

import ua.lviv.iot.domain.Order;

import java.util.List;

public interface OrderService extends GeneralService<Order, Integer> {
    List<Order> getVipOrders(); // Orders cost >= 900$
}
