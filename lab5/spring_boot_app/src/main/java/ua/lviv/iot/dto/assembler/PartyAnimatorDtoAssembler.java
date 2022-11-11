package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.PartyAnimatorDto;
import ua.lviv.iot.domain.PartyAnimator;
import ua.lviv.iot.controller.PartyAnimatorController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PartyAnimatorDtoAssembler implements RepresentationModelAssembler<PartyAnimator, PartyAnimatorDto> {
    @Override
    public PartyAnimatorDto toModel(PartyAnimator entity) {
        PartyAnimatorDto partyAnimatorDto = PartyAnimatorDto.builder().id(entity.getId()).firstName(entity.getFirstName()).secondName(entity.getSecondName()).phoneNumber(entity.getPhoneNumber()).uniquePerformance(entity.getUniquePerformance()).workExperienceInYears(entity.getWorkExperienceInYears()).orderId(entity.getOrderId()).build();
        Link selfLink = linkTo(methodOn(PartyAnimatorController.class).getPartyAnimator(entity.getId())).withSelfRel();
        partyAnimatorDto.add(selfLink);
        return partyAnimatorDto;
    }

    @Override
    public CollectionModel<PartyAnimatorDto> toCollectionModel(Iterable<? extends PartyAnimator> entities) {
        CollectionModel<PartyAnimatorDto> partyAnimatorsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(PartyAnimatorController.class).getAllPartyAnimators()).withSelfRel();
        partyAnimatorsDto.add(selfLink);
        return partyAnimatorsDto;
    }
}
