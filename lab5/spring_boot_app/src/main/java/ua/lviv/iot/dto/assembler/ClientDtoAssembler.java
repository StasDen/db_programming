package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.ClientDto;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.controller.ClientController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ClientDtoAssembler implements RepresentationModelAssembler<Client, ClientDto> {
    @Override
    public ClientDto toModel(Client entity) {
        ClientDto clientDto = ClientDto.builder().id(entity.getId()).firstName(entity.getFirstName()).secondName(entity.getSecondName()).phoneNumber(entity.getPhoneNumber()).clientCardId((entity.getClientCardId())).build();
        Link selfLink = linkTo(methodOn(ClientController.class).getClient(entity.getId())).withSelfRel();
        clientDto.add(selfLink);
        return clientDto;
    }

    @Override
    public CollectionModel<ClientDto> toCollectionModel(Iterable<? extends Client> entities) {
        CollectionModel<ClientDto> clientsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ClientController.class).getAllClients()).withSelfRel();
        clientsDto.add(selfLink);
        return clientsDto;
    }
}
