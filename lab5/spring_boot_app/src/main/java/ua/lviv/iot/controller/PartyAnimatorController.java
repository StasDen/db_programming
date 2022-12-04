package ua.lviv.iot.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.PartyAnimator;
import ua.lviv.iot.dto.PartyAnimatorDto;
import ua.lviv.iot.dto.assembler.PartyAnimatorDtoAssembler;
import ua.lviv.iot.service.PartyAnimatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/api/partyAnimators")
public class PartyAnimatorController {
    @Autowired
    private PartyAnimatorService partyAnimatorService;

    @Autowired
    private PartyAnimatorDtoAssembler partyAnimatorDtoAssembler;

    @GetMapping(value = "/{partyAnimatorId}")
    public ResponseEntity<PartyAnimatorDto> getPartyAnimator(@PathVariable Integer partyAnimatorId) {
        PartyAnimator partyAnimator = partyAnimatorService.findById(partyAnimatorId);
        PartyAnimatorDto partyAnimatorDto = partyAnimatorDtoAssembler.toModel(partyAnimator);
        return new ResponseEntity<>(partyAnimatorDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PartyAnimatorDto>> getAllPartyAnimators() {
        List<PartyAnimator> partyAnimators = partyAnimatorService.findAll();
        CollectionModel<PartyAnimatorDto> partyAnimatorsDto = partyAnimatorDtoAssembler.toCollectionModel(partyAnimators);
        return new ResponseEntity<>(partyAnimatorsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<PartyAnimatorDto> addPartyAnimator(@RequestBody PartyAnimator partyAnimator) {
        PartyAnimator newPartyAnimator = partyAnimatorService.create(partyAnimator);
        PartyAnimatorDto partyAnimatorDto = partyAnimatorDtoAssembler.toModel(newPartyAnimator);
        return new ResponseEntity<>(partyAnimatorDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{partyAnimatorId}")
    public ResponseEntity<?> updatePartyAnimator(@RequestBody PartyAnimator uPartyAnimator, @PathVariable Integer partyAnimatorId) {
        partyAnimatorService.update(partyAnimatorId, uPartyAnimator);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{partyAnimatorId}")
    public ResponseEntity<?> deletePartyAnimator(@PathVariable Integer partyAnimatorId) {
        partyAnimatorService.delete(partyAnimatorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/uniquePerformances")
    public ResponseEntity<CollectionModel<PartyAnimatorDto>> getPartyAnimatorsWithUniquePerformances() {
        List<PartyAnimator> partyAnimators = partyAnimatorService.findPartyAnimatorsWithUniquePerformances();
        CollectionModel<PartyAnimatorDto> partyAnimatorsDto = partyAnimatorDtoAssembler.toCollectionModel(partyAnimators);
        return new ResponseEntity<>(partyAnimatorsDto, HttpStatus.OK);
    }
}
