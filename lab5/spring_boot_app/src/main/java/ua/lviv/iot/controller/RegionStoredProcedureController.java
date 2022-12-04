package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.service.RegionStoredProcedureService;
import ua.lviv.iot.dto.assembler.RegionDtoAssembler;
import ua.lviv.iot.dto.RegionDto;

import java.util.List;

@RestController
@RequestMapping(value = "/api/regions")
public class RegionStoredProcedureController {
    @Autowired
    RegionStoredProcedureService regionStoredProcedureService;

    @Autowired
    RegionDtoAssembler regionDtoAssembler;

    @PostMapping(value = "/name/noname")
    public ResponseEntity<CollectionModel<RegionDto>> insertNonameRegions() {
        List<Region> regions = regionStoredProcedureService.insertNonameRegions();
        CollectionModel<RegionDto> regionsDto = regionDtoAssembler.toCollectionModel(regions);
        return new ResponseEntity<>(regionsDto, HttpStatus.CREATED);
    }
}
