package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Consultant;

import java.util.List;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Integer> {
    List<Consultant> findConsultantsByEntertainmentAgencyId(Integer id);
}
