package ua.lviv.iot.controller;

import ua.lviv.iot.domain.Discount;

import java.util.Optional;

public interface DiscountController extends GeneralController<Discount, Integer> {
    Optional<Discount> getDiscountByHolidayName(String name);
}
