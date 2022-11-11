package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.dto.EventDto;
import ua.lviv.iot.domain.Event;
import ua.lviv.iot.controller.EventController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EventDtoAssembler implements RepresentationModelAssembler<Event, EventDto> {
    @Override
    public EventDto toModel(Event entity) {
        EventDto eventDto = EventDto.builder().id(entity.getId()).name(entity.getName()).animatorsNum(entity.getAnimatorsNum()).visitorsNum(entity.getVisitorsNum()).date(entity.getDate()).address(entity.getAddress()).durationInHours(entity.getDurationInHours()).cityId(entity.getCityId()).build();
        Link selfLink = linkTo(methodOn(EventController.class).getEvent(entity.getId())).withSelfRel();
        eventDto.add(selfLink);
        return eventDto;
    }

    @Override
    public CollectionModel<EventDto> toCollectionModel(Iterable<? extends Event> entities) {
        CollectionModel<EventDto> eventsDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(EventController.class).getAllEvents()).withSelfRel();
        eventsDto.add(selfLink);
        return eventsDto;
    }
}
