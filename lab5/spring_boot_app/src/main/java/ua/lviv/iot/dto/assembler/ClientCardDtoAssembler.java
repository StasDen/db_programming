package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.ClientCardDto;
import ua.lviv.iot.domain.ClientCard;
import ua.lviv.iot.controller.ClientCardController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ClientCardDtoAssembler implements RepresentationModelAssembler<ClientCard, ClientCardDto> {
    @Override
    public ClientCardDto toModel(ClientCard entity) {
        ClientCardDto clientCardDto = ClientCardDto.builder().id(entity.getId()).name(entity.getName()).discountPercentage(entity.getDiscountPercentage()).build();
        Link selfLink = linkTo(methodOn(ClientCardController.class).getClientCard(entity.getId())).withSelfRel();
        clientCardDto.add(selfLink);
        return clientCardDto;
    }

    @Override
    public CollectionModel<ClientCardDto> toCollectionModel(Iterable<? extends ClientCard> clientCards) {
        CollectionModel<ClientCardDto> clientCardsDto = RepresentationModelAssembler.super.toCollectionModel(clientCards);
        Link selfLink = linkTo(methodOn(ClientCardController.class).getAllClientCards()).withSelfRel();
        clientCardsDto.add(selfLink);
        return clientCardsDto;
    }
}
