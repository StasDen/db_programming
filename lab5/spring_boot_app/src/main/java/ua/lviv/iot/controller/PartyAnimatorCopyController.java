package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.PartyAnimatorCopy;
import ua.lviv.iot.dto.PartyAnimatorCopyDto;
import ua.lviv.iot.dto.assembler.PartyAnimatorCopyDtoAssembler;
import ua.lviv.iot.service.PartyAnimatorCopyService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/animator-logs")
public class PartyAnimatorCopyController {
    @Autowired
    PartyAnimatorCopyService partyAnimatorCopyService;

    @Autowired
    PartyAnimatorCopyDtoAssembler partyAnimatorCopyDtoAssembler;

    @GetMapping(value = "/{logId}")
    public ResponseEntity<PartyAnimatorCopyDto> getAnimatorLog(@PathVariable Integer logId) {
        PartyAnimatorCopy animatorLog = partyAnimatorCopyService.findById(logId);
        PartyAnimatorCopyDto animatorLogDto = partyAnimatorCopyDtoAssembler.toModel(animatorLog);
        return new ResponseEntity<>(animatorLogDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PartyAnimatorCopyDto>> getAllAnimatorsLogs() {
        List<PartyAnimatorCopy> animatorsLogs = partyAnimatorCopyService.findAll();
        CollectionModel<PartyAnimatorCopyDto> animatorsLogsDto = partyAnimatorCopyDtoAssembler.toCollectionModel(animatorsLogs);
        return new ResponseEntity<>(animatorsLogsDto, HttpStatus.OK);
    }
}
