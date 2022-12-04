package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Ledger;
import ua.lviv.iot.repository.LedgerRepository;
import ua.lviv.iot.service.LedgerService;
import ua.lviv.iot.exception.LogNotFoundException;

import java.util.List;

@Service
public class LedgerServiceImp implements LedgerService {
    @Autowired
    LedgerRepository ledgerRepository;

    public Ledger findById(Integer id) {
        return ledgerRepository.findById(id).orElseThrow(() -> new LogNotFoundException(id));
    }

    public List<Ledger> findAll() {
        return ledgerRepository.findAll();
    }
}
