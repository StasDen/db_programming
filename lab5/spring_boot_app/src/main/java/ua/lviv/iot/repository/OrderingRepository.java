package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Ordering;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Integer> {
    @Transactional
    @Procedure
    List<Ordering> getOrderingsAfterCost(Integer inCost);

    @Transactional
    @Procedure
    Integer getNumOfOrderingsAfterCost(Integer inCost);
}
