package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Ledger;
import ua.lviv.iot.repository.LedgerRepository;
import ua.lviv.iot.service.LedgerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LedgerServiceImp implements LedgerService {
    @Autowired
    LedgerRepository ledgerRepository;

    public Ledger findById(Integer id) {
        return ledgerRepository.findById(id);
    }

    public List<Ledger> findAll() {
        return ledgerRepository.findAll();
    }

    @Transactional
    public Ledger create(Ledger ledger) {
        ledgerRepository.save(ledger);
        return ledger;
    }

    @Transactional
    public void update(Integer id, Ledger uLedger) {
        Ledger ledger = ledgerRepository.findById(id);
        ledger.setClient(uLedger.getClient());
        ledger.setOrder(uLedger.getOrder());
        ledger.setAction(uLedger.getAction());
        ledger.setTime(uLedger.getTime());
        ledger.setUser(uLedger.getUser());
        ledgerRepository.save(ledger);
    }

    @Transactional
    public void delete(Integer id) {
        Ledger ledger = ledgerRepository.findById(id);
        ledgerRepository.delete(ledger);
    }
}
