package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Ledger;
import ua.lviv.iot.dto.LedgerDto;
import ua.lviv.iot.dto.assembler.LedgerDtoAssembler;
import ua.lviv.iot.service.LedgerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/logs")
public class LedgerController {
    @Autowired
    LedgerService ledgerService;

    @Autowired
    LedgerDtoAssembler ledgerDtoAssembler;

    @GetMapping(value = "/{logId}")
    public ResponseEntity<LedgerDto> getLog(@PathVariable Integer logId) {
        Ledger ledger = ledgerService.findById(logId);
        LedgerDto ledgerDto = ledgerDtoAssembler.toModel(ledger);
        return new ResponseEntity<>(ledgerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LedgerDto>> getAllLogs() {
        List<Ledger> ledgers = ledgerService.findAll();
        CollectionModel<LedgerDto> ledgersDto = ledgerDtoAssembler.toCollectionModel(ledgers);
        return new ResponseEntity<>(ledgersDto, HttpStatus.OK);
    }
}
