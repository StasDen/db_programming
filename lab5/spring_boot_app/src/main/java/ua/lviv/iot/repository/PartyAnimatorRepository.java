package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.PartyAnimator;

import java.util.List;

@Repository
public interface PartyAnimatorRepository extends JpaRepository<PartyAnimator, Integer> {
    @Query(value = "SELECT * FROM party_animator WHERE unique_performance IS NOT NULL", nativeQuery = true)
    List<PartyAnimator> findPartyAnimatorsWithUniquePerformances();
}
