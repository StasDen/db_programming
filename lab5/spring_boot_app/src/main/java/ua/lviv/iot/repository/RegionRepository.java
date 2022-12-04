package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Region;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Transactional
    @Procedure
    List<Region> insertNonameRegions();
}
