package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.EntertainmentAgencyDto;
import ua.lviv.iot.domain.EntertainmentAgency;
import ua.lviv.iot.controller.EntertainmentAgencyController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EntertainmentAgencyDtoAssembler implements RepresentationModelAssembler<EntertainmentAgency, EntertainmentAgencyDto> {
    @Override
    public EntertainmentAgencyDto toModel(EntertainmentAgency entity) {
        EntertainmentAgencyDto entertainmentAgencyDto = EntertainmentAgencyDto.builder().id(entity.getId()).name(entity.getName()).contactNumber(entity.getContactNumber()).address(entity.getAddress()).animatorId(entity.getAnimatorId()).cityId(entity.getCityId()).build();
        Link selfLink = linkTo(methodOn(EntertainmentAgencyController.class).getEntertainmentAgency(entity.getId())).withSelfRel();
        entertainmentAgencyDto.add(selfLink);
        return entertainmentAgencyDto;
    }

    @Override
    public CollectionModel<EntertainmentAgencyDto> toCollectionModel(Iterable<? extends EntertainmentAgency> entities) {
        CollectionModel<EntertainmentAgencyDto> entertainmentAgenciesDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(EntertainmentAgencyController.class).getAllEntertainmentAgencies()).withSelfRel();
        entertainmentAgenciesDto.add(selfLink);
        return entertainmentAgenciesDto;
    }
}
