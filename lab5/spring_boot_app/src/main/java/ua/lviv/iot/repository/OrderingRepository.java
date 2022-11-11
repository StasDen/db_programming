package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Ordering;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Integer> {
}
