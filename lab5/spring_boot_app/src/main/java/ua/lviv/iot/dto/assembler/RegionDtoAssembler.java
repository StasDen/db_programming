package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.RegionDto;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.controller.RegionController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RegionDtoAssembler implements RepresentationModelAssembler<Region, RegionDto> {
    @Override
    public RegionDto toModel(Region entity) {
        RegionDto regionDto = RegionDto.builder().id(entity.getId()).name(entity.getName()).build();
        Link selfLink = linkTo(methodOn(RegionController.class).getRegion(entity.getId())).withSelfRel();
        regionDto.add(selfLink);
        return regionDto;
    }

    @Override
    public CollectionModel<RegionDto> toCollectionModel(Iterable<? extends Region> entities) {
        CollectionModel<RegionDto> regionsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(RegionController.class).getAllRegions()).withSelfRel();
        regionsDto.add(selfLink);
        return regionsDto;
    }
}
