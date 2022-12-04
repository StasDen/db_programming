package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.controller.PartyAnimatorCopyController;
import ua.lviv.iot.domain.PartyAnimatorCopy;
import ua.lviv.iot.dto.PartyAnimatorCopyDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PartyAnimatorCopyDtoAssembler implements RepresentationModelAssembler<PartyAnimatorCopy, PartyAnimatorCopyDto> {
    @Override
    public PartyAnimatorCopyDto toModel(PartyAnimatorCopy entity) {
        PartyAnimatorCopyDto animatorLogDto = PartyAnimatorCopyDto.builder().id(entity.getId()).firstName(entity.getFirstName()).lastName(entity.getLastName()).phoneNumberOld(entity.getPhoneNumberOld()).phoneNumberUpd(entity.getPhoneNumberUpd()).uniquePerformance(entity.getUniquePerformance()).workExperienceInYears(entity.getWorkExperienceInYears()).orderId(entity.getOrderId()).action(entity.getAction()).timeStamp(entity.getTimeStamp()).user(entity.getUser()).build();
        Link selfLink = linkTo(methodOn(PartyAnimatorCopyController.class).getAnimatorLog(animatorLogDto.getId())).withSelfRel();
        animatorLogDto.add(selfLink);
        return animatorLogDto;
    }

    @Override
    public CollectionModel<PartyAnimatorCopyDto> toCollectionModel(Iterable<? extends PartyAnimatorCopy> entities) {
        CollectionModel<PartyAnimatorCopyDto> animatorLogsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(PartyAnimatorCopyController.class).getAllAnimatorsLogs()).withSelfRel();
        animatorLogsDto.add(selfLink);
        return animatorLogsDto;
    }
}
