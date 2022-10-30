package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Discount;
import ua.lviv.iot.service.DiscountService;
import ua.lviv.iot.controller.DiscountController;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountControllerImp implements DiscountController {
    @Autowired
    public DiscountService discountService;

    @Override
    public List<Discount> findAll() {
        return discountService.findAll();
    }

    @Override
    public Optional<Discount> findById(Integer id) {
        return discountService.findById(id);
    }

    @Override
    public int create(Discount discount) {
        return discountService.create(discount);
    }

    @Override
    public int delete(Integer id) {
        return discountService.delete(id);
    }

    @Override
    public int update(Integer id, Discount discount) {
        return discountService.update(id, discount);
    }
}
