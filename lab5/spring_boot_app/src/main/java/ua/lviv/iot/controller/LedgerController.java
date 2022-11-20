package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Ledger;
import ua.lviv.iot.service.LedgerService;

import java.util.List;

@RestController
@RequestMapping(value = "api/ledgers")
public class LedgerController {
    @Autowired
    LedgerService ledgerService;

    @Autowired
    LedgerDtoAssembler ledgerDtoAssembler;

    @GetMapping(value = "/{ledgerId}")
    public ResponseEntity<LedgerDto> getLedger(@PathVariable Integer ledgerId) {
        Ledger ledger = ledgerService.findById(ledgerId);
        LedgerDto ledgerDto = ledgerDtoAssembler.toModel(ledger);
        return ResponseEntity <>(ledgerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LedgerDto>> getAllLedgers() {
        List<Ledger> ledgers = ledgerService.findAll();
        CollectionModel<LedgerDto> ledgersDto = ledgerDtoAssembler.toCollectionModel(ledgers);
        return ResponseEntity.ok(ledgersDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<LedgerDto> addLedger(@RequestBody Ledger ledger) {
        Ledger newLedger = ledgerService.create(ledger);
        LedgerDto ledgerDto = ledgerDtoAssembler.toModel(ledgerDto);
        return ResponseEntity <>(ledgerDto, HttpStatus.CREATED);
    }
}
