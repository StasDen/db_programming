package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.ConsultantDto;
import ua.lviv.iot.domain.Consultant;
import ua.lviv.iot.controller.ConsultantController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ConsultantDtoAssembler implements RepresentationModelAssembler<Consultant, ConsultantDto> {
    @Override
    public ConsultantDto toModel(Consultant entity) {
        ConsultantDto consultantDto = ConsultantDto.builder().id(entity.getId()).firstName(entity.getFirstName()).secondName(entity.getSecondName()).phoneNumber(entity.getPhoneNumber()).entertainmentAgencyId(entity.getEntertainmentAgencyId()).build();
        Link selfLink = linkTo(methodOn(ConsultantController.class).getConsultant(entity.getId())).withSelfRel();
        consultantDto.add(selfLink);
        return consultantDto;
    }

    @Override
    public CollectionModel<ConsultantDto> toCollectionModel(Iterable<? extends Consultant> entities) {
        CollectionModel<ConsultantDto> consultantsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ConsultantController.class).getAllConsultants()).withSelfRel();
        consultantsDto.add(selfLink);
        return consultantsDto;
    }
}
