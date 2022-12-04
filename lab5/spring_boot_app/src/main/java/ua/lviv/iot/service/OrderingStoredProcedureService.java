package ua.lviv.iot.service;

import ua.lviv.iot.domain.Ordering;

import java.util.List;

public interface OrderingStoredProcedureService {
    List<Ordering> getOrderingsAfterCost(Integer inCost);

    Integer getNumOfOrderingsAfterCost(Integer inCost);
}
