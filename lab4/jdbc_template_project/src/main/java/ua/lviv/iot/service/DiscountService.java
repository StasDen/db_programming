package ua.lviv.iot.service;

import ua.lviv.iot.domain.Discount;

import java.util.Optional;

public interface DiscountService extends GeneralService<Discount, Integer> {
    Optional<Discount> getDiscountByHolidayName(String name);
}
