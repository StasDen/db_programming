package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.DiscountRepository;
import ua.lviv.iot.service.DiscountService;
import ua.lviv.iot.domain.Discount;
import ua.lviv.iot.exception.DiscountNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class DiscountServiceImp implements DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    public Discount findById(Integer id) {
        return discountRepository.findById(id).orElseThrow(() -> new DiscountNotFoundException(id));
    }

    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Transactional
    public Discount create(Discount discount) {
        discountRepository.save(discount);
        return discount;
    }

    @Transactional
    public void update(Integer id, Discount uDiscount) {
        Discount discount = discountRepository.findById(id).orElseThrow(() -> new DiscountNotFoundException(id));
        discount.setName(uDiscount.getName());
        discount.setPercentage(uDiscount.getPercentage());
        discountRepository.save(discount);
    }

    @Transactional
    public void delete(Integer id) {
        Discount discount = discountRepository.findById(id).orElseThrow(() -> new DiscountNotFoundException(id));
        discountRepository.delete(discount);
    }

    public Discount findDiscountByName(String name) {
        return discountRepository.findDiscountByName(name);
    }
}
