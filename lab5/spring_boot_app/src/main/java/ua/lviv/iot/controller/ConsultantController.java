package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.ConsultantDto;
import ua.lviv.iot.dto.assembler.ConsultantDtoAssembler;
import ua.lviv.iot.service.ConsultantService;
import ua.lviv.iot.domain.Consultant;

import java.util.List;

@RestController
@RequestMapping(value = "/api/consultants")
public class ConsultantController {
    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private ConsultantDtoAssembler consultantDtoAssembler;

    @GetMapping(value = "/{consultantId}")
    public ResponseEntity<ConsultantDto> getConsultant(@PathVariable Integer consultantId) {
        Consultant consultant = consultantService.findById(consultantId);
        ConsultantDto consultantDto = consultantDtoAssembler.toModel(consultant);
        return new ResponseEntity<>(consultantDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ConsultantDto>> getAllConsultants() {
        List<Consultant> consultants = consultantService.findAll();
        CollectionModel<ConsultantDto> consultantsDto = consultantDtoAssembler.toCollectionModel(consultants);
        return new ResponseEntity<>(consultantsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ConsultantDto> addConsultant(@RequestBody Consultant consultant) {
        Consultant newConsultant = consultantService.create(consultant);
        ConsultantDto consultantDto = consultantDtoAssembler.toModel(newConsultant);
        return new ResponseEntity<>(consultantDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{consultantId}")
    public ResponseEntity<?> updateConsultant(@RequestBody Consultant uConsultant, @PathVariable Integer consultantId) {
        consultantService.update(consultantId, uConsultant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{consultantId}")
    public ResponseEntity<?> deleteConsultant(@PathVariable Integer consultantId) {
        consultantService.delete(consultantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/entertainmentAgency/{entertainmentAgencyId}")
    public ResponseEntity<CollectionModel<ConsultantDto>> findConsultantsByEntertainmentAgencyId(@PathVariable Integer entertainmentAgencyId) {
        List<Consultant> consultants = consultantService.findConsultantsByEntertainmentAgencyId(entertainmentAgencyId);
        CollectionModel<ConsultantDto> consultantsDto = consultantDtoAssembler.toCollectionModel(consultants);
        return new ResponseEntity<>(consultantsDto, HttpStatus.OK);
    }
}
