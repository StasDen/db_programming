package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.DiscountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.service.DiscountService;
import ua.lviv.iot.domain.Discount;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImp implements DiscountService {
    @Autowired
    public DiscountDao discountDao;

    @Override
    public List<Discount> findAll() {
        return discountDao.findAll();
    }

    @Override
    public Optional<Discount> findById(Integer id) {
        return discountDao.findById(id);
    }

    @Override
    public int create(Discount discount) {
        return discountDao.create(discount);
    }

    @Override
    public int delete(Integer id) {
        return discountDao.delete(id);
    }

    @Override
    public int update(Integer id, Discount discount) {
        return discountDao.update(id, discount);
    }
}
