package ua.lviv.iot.service;

import ua.lviv.iot.domain.Ledger;

import java.util.List;

public interface LedgerService {
    List<Ledger> findAll();

    Ledger findById(Integer id);
}
