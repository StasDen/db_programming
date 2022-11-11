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
@Relation(itemRelation = "ordering", collectionRelation = "orderings")
public class OrderingDto extends RepresentationModel<OrderingDto> {
    private final Integer id;
    private final String name;
    private final Integer costInUsd;
    private final Integer eventId;
    private final Integer clientId;
    private final Integer discountId;
    private final Integer entertainmentAgencyId;
}
