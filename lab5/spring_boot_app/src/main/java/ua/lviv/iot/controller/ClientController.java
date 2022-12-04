package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.dto.ClientDto;
import ua.lviv.iot.dto.assembler.ClientDtoAssembler;
import ua.lviv.iot.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {
    @Autowired
    private ClientDtoAssembler clientDtoAssembler;

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{clientId}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Integer clientId) {
        Client client = clientService.findById(clientId);
        ClientDto clientDto = clientDtoAssembler.toModel(client);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ClientDto>> getAllClients() {
        List<Client> clients = clientService.findAll();
        CollectionModel<ClientDto> clientsDto = clientDtoAssembler.toCollectionModel(clients);
        return new ResponseEntity<>(clientsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ClientDto> addClient(@RequestBody Client client) {
        Client newClient = clientService.create(client);
        ClientDto clientDto = clientDtoAssembler.toModel(newClient);
        return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{clientId}")
    public ResponseEntity<?> updateClient(@RequestBody Client uClient, @PathVariable Integer clientId) {
        clientService.update(clientId, uClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer clientId) {
        clientService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/client/{clientId}/ordering/{orderingId}")
    public ResponseEntity<ClientDto> addOrderingForClient(@PathVariable Integer clientId, @PathVariable Integer orderingId) {
        Client client = clientService.addOrderingForClient(clientId, orderingId);
        ClientDto clientDto = clientDtoAssembler.toModel(client);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/client/{clientId}/ordering/{orderingId}")
    public ResponseEntity<ClientDto> removeOrderingForClient(@PathVariable Integer clientId, @PathVariable Integer orderingId) {
        Client client = clientService.removeOrderingForClient(clientId, orderingId);
        ClientDto clientDto = clientDtoAssembler.toModel(client);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }
}
