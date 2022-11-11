package ua.lviv.iot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "event", collectionRelation = "events")
public class EventDto extends RepresentationModel<EventDto> {
    private final Integer id;
    private final String name;
    private final Integer animatorsNum;
    private final Integer visitorsNum;
    private final String date;
    private final String address;
    private final Integer durationInHours;
    private final Integer cityId;
}
