package ua.lviv.iot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "animatorLog", collectionRelation = "animatorsLogs")
public class PartyAnimatorCopyDto extends RepresentationModel<PartyAnimatorCopyDto> {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String phoneNumberOld;
    private final String phoneNumberUpd;
    private final String uniquePerformance;
    private final Integer workExperienceInYears;
    private final Integer orderId;
    private final String action;
    private final Date timeStamp;
    private final String user;
}
