package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
