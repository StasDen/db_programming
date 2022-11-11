package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.EntertainmentAgencyDto;
import ua.lviv.iot.dto.assembler.EntertainmentAgencyDtoAssembler;
import ua.lviv.iot.service.EntertainmentAgencyService;
import ua.lviv.iot.domain.EntertainmentAgency;

import java.util.List;

@RestController
@RequestMapping(value = "/api/entertainmentAgencies")
public class EntertainmentAgencyController {
    @Autowired
    private EntertainmentAgencyService entertainmentAgencyService;

    @Autowired
    private EntertainmentAgencyDtoAssembler entertainmentAgencyDtoAssembler;

    @GetMapping(value = "/{entertainmentAgencyId}")
    public ResponseEntity<EntertainmentAgencyDto> getEntertainmentAgency(@PathVariable Integer entertainmentAgencyId) {
        EntertainmentAgency entertainmentAgency = entertainmentAgencyService.findById(entertainmentAgencyId);
        EntertainmentAgencyDto entertainmentAgencyDto = entertainmentAgencyDtoAssembler.toModel(entertainmentAgency);
        return new ResponseEntity<>(entertainmentAgencyDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<EntertainmentAgencyDto>> getAllEntertainmentAgencies() {
        List<EntertainmentAgency> entertainmentAgencies = entertainmentAgencyService.findAll();
        CollectionModel<EntertainmentAgencyDto> entertainmentAgenciesDto = entertainmentAgencyDtoAssembler.toCollectionModel(entertainmentAgencies);
        return new ResponseEntity<>(entertainmentAgenciesDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<EntertainmentAgencyDto> addEntertainmentAgency(@RequestBody EntertainmentAgency entertainmentAgency) {
        EntertainmentAgency newEntertainmentAgency = entertainmentAgencyService.create(entertainmentAgency);
        EntertainmentAgencyDto entertainmentAgencyDto = entertainmentAgencyDtoAssembler.toModel(newEntertainmentAgency);
        return new ResponseEntity<>(entertainmentAgencyDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{entertainmentAgencyId}")
    public ResponseEntity<?> updateEntertainmentAgency(@RequestBody EntertainmentAgency uEntertainmentAgency, @PathVariable Integer entertainmentAgencyId) {
        entertainmentAgencyService.update(entertainmentAgencyId, uEntertainmentAgency);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{entertainmentAgencyId}")
    public ResponseEntity<?> deleteEntertainmentAgency(@PathVariable Integer entertainmentAgencyId) {
        entertainmentAgencyService.delete(entertainmentAgencyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/city/{cityId}")
    public ResponseEntity<CollectionModel<EntertainmentAgencyDto>> getAllEntertainmentAgenciesByCityId(@PathVariable Integer cityId) {
        List<EntertainmentAgency> entertainmentAgencies = entertainmentAgencyService.findAllEntertainmentAgenciesByCityId(cityId);
        CollectionModel<EntertainmentAgencyDto> entertainmentAgenciesDto = entertainmentAgencyDtoAssembler.toCollectionModel(entertainmentAgencies);
        return new ResponseEntity<>(entertainmentAgenciesDto, HttpStatus.OK);
    }
}
