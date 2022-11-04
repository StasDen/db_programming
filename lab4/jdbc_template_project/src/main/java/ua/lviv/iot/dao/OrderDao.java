package ua.lviv.iot.dao;

import ua.lviv.iot.domain.Order;

import java.util.List;

public interface OrderDao extends GeneralDao<Order, Integer> {
    List<Order> getVipOrders();
}
