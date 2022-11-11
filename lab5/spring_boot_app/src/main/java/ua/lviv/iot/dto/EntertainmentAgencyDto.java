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
@Relation(itemRelation = "entertainmentAgency", collectionRelation = "entertainmentAgencies")
public class EntertainmentAgencyDto extends RepresentationModel<EntertainmentAgencyDto> {
    private final Integer id;
    private final String name;
    private final String contactNumber;
    private final String address;
    private final Integer animatorId;
    private final Integer cityId;
}
