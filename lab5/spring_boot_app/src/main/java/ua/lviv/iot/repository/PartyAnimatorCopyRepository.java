package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.PartyAnimatorCopy;

@Repository
public interface PartyAnimatorCopyRepository extends JpaRepository<PartyAnimatorCopy, Integer> {
}
