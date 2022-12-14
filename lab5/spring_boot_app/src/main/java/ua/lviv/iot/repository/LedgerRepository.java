package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Ledger;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Integer> {
}
