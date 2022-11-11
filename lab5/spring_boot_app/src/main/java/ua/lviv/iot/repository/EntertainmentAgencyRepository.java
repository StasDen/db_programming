package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.EntertainmentAgency;

import java.util.List;

@Repository
public interface EntertainmentAgencyRepository extends JpaRepository<EntertainmentAgency, Integer> {
    List<EntertainmentAgency> findAllEntertainmentAgenciesByCityId(Integer id);
}
