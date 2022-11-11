package ua.lviv.iot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false) // Default val
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "discount", collectionRelation = "discounts")
public class DiscountDto extends RepresentationModel<DiscountDto> {
    private final Integer id;
    private final String name;
    private final Integer percentage;
}
