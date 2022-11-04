package ua.lviv.iot.dao;

import ua.lviv.iot.domain.Discount;

import java.util.Optional;

public interface DiscountDao extends GeneralDao<Discount, Integer> {
    Optional<Discount> getDiscountByHolidayName(String name);
}
