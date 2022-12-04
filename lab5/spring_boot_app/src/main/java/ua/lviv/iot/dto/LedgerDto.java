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
@Relation(itemRelation = "log", collectionRelation = "logs")
public class LedgerDto extends RepresentationModel<LedgerDto> {
    private final Integer id;
    private final String client;
    private final String ordering;
    private final String action;
    private final Date time;
    private final String user;
}
