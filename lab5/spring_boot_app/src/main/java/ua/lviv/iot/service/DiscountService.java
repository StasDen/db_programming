package ua.lviv.iot.service;

import ua.lviv.iot.domain.Discount;

public interface DiscountService extends GeneralService<Discount, Integer> {
    Discount findDiscountByName(String name);
}
