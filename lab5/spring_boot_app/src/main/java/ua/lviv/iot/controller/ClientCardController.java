package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.ClientCardDto;
import ua.lviv.iot.dto.assembler.ClientCardDtoAssembler;
import ua.lviv.iot.service.ClientCardService;
import ua.lviv.iot.domain.ClientCard;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clientCards")
public class ClientCardController {
    @Autowired
    private ClientCardDtoAssembler clientCardDtoAssembler;

    @Autowired
    private ClientCardService clientCardService;

    @GetMapping(value = "/{clientCardId}")
    public ResponseEntity<ClientCardDto> getClientCard(@PathVariable Integer clientCardId) {
        ClientCard clientCard = clientCardService.findById(clientCardId);
        ClientCardDto clientCardDto = clientCardDtoAssembler.toModel(clientCard);
        return new ResponseEntity<>(clientCardDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ClientCardDto>> getAllClientCards() {
        List<ClientCard> clientCards = clientCardService.findAll();
        CollectionModel<ClientCardDto> clientCardsDto = clientCardDtoAssembler.toCollectionModel(clientCards);
        return new ResponseEntity<>(clientCardsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ClientCardDto> addClientCard(@RequestBody ClientCard clientCard) {
        ClientCard newClientCard = clientCardService.create(clientCard);
        ClientCardDto clientCardDto = clientCardDtoAssembler.toModel(newClientCard);
        return new ResponseEntity<>(clientCardDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{clientCardId}")
    public ResponseEntity<?> updateClientCard(@RequestBody ClientCard uClientCard, @PathVariable Integer clientCardId) {
        clientCardService.update(clientCardId, uClientCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clientCardId}")
    public ResponseEntity<?> deleteClientCard(@PathVariable Integer clientCardId) {
        clientCardService.delete(clientCardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
