package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.ClientCard;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Integer> {
}
