package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    Discount findDiscountByName(String name);
}
