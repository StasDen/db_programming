package ua.lviv.iot.controller;

import ua.lviv.iot.domain.Order;

import java.util.List;

public interface OrderController extends GeneralController<Order, Integer> {
    List<Order> getVipOrders();
}
