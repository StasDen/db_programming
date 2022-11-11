package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.DiscountDto;
import ua.lviv.iot.domain.Discount;
import ua.lviv.iot.controller.DiscountController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DiscountDtoAssembler implements RepresentationModelAssembler<Discount, DiscountDto> {
    @Override
    public DiscountDto toModel(Discount entity) {
        DiscountDto discountDto = DiscountDto.builder().id(entity.getId()).name(entity.getName()).percentage(entity.getPercentage()).build();
        Link selfLink = linkTo(methodOn(DiscountController.class).getDiscount(entity.getId())).withSelfRel();
        discountDto.add(selfLink);
        return discountDto;
    }

    @Override
    public CollectionModel<DiscountDto> toCollectionModel(Iterable<? extends Discount> entities) {
        CollectionModel<DiscountDto> discountsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DiscountController.class).getAllDiscounts()).withSelfRel();
        discountsDto.add(selfLink);
        return discountsDto;
    }
}
