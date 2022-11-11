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
@Relation(itemRelation = "consultant", collectionRelation = "consultants")
public class ConsultantDto extends RepresentationModel<ConsultantDto> {
    private final Integer id;
    private final String firstName;
    private final String secondName;
    private final String phoneNumber;
    private final Integer entertainmentAgencyId;
}
