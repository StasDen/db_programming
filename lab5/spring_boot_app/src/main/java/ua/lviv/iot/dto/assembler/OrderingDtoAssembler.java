package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.OrderingDto;
import ua.lviv.iot.domain.Ordering;
import ua.lviv.iot.controller.OrderingController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderingDtoAssembler implements RepresentationModelAssembler<Ordering, OrderingDto> {
    @Override
    public OrderingDto toModel(Ordering entity) {
        OrderingDto orderingDto = OrderingDto.builder().id(entity.getId()).name(entity.getName()).costInUsd(entity.getCostInUsd()).eventId(entity.getEventId()).clientId(entity.getClientId()).discountId(entity.getDiscountId()).entertainmentAgencyId(entity.getEntertainmentAgencyId()).build();
        Link selfLink = linkTo(methodOn(OrderingController.class).getOrdering(entity.getId())).withSelfRel();
        orderingDto.add(selfLink);
        return orderingDto;
    }

    @Override
    public CollectionModel<OrderingDto> toCollectionModel(Iterable<? extends Ordering> entities) {
        CollectionModel<OrderingDto> orderingsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(OrderingController.class).getAllOrderings()).withSelfRel();
        orderingsDto.add(selfLink);
        return orderingsDto;
    }
}
