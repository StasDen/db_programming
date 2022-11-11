package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
