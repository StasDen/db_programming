package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Ordering;
import ua.lviv.iot.repository.OrderingRepository;
import ua.lviv.iot.service.OrderingStoredProcedureService;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class OrderingStoredProcedureServiceImp implements OrderingStoredProcedureService {
    @Autowired
    OrderingRepository orderingRepository;

    @Transactional
    @Override
    public List<Ordering> getOrderingsAfterCost(Integer inCost) {
        return orderingRepository.getOrderingsAfterCost(inCost);
    }

    @Transactional
    @Override
    public Integer getNumOfOrderingsAfterCost(Integer inCost) {
        return orderingRepository.getNumOfOrderingsAfterCost(inCost);
    }
}
