package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.OrderingRepository;
import ua.lviv.iot.service.OrderingService;
import ua.lviv.iot.domain.Ordering;
import ua.lviv.iot.exception.OrderingNotFountException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class OrderingServiceImp implements OrderingService {
    @Autowired
    OrderingRepository orderingRepository;

    public Ordering findById(Integer id) {
        return orderingRepository.findById(id).orElseThrow(() -> new OrderingNotFountException(id));
    }

    public List<Ordering> findAll() {
        return orderingRepository.findAll();
    }

    @Transactional
    public Ordering create(Ordering ordering) {
        orderingRepository.save(ordering);
        return ordering;
    }

    @Transactional
    public void update(Integer id, Ordering uOrder) {
        Ordering order = orderingRepository.findById(id).orElseThrow(() -> new OrderingNotFountException(id));
        order.setName(uOrder.getName());
        order.setCostInUsd(uOrder.getCostInUsd());
        order.setEventId(uOrder.getEventId());
        order.setDiscountId(uOrder.getDiscountId());
        order.setClientId(uOrder.getClientId());
        order.setEntertainmentAgencyId(uOrder.getEntertainmentAgencyId());
        orderingRepository.save(order);
    }

    @Transactional
    public void delete(Integer id) {
        Ordering ordering = orderingRepository.findById(id).orElseThrow(() -> new OrderingNotFountException(id));
        orderingRepository.delete(ordering);
    }
}
