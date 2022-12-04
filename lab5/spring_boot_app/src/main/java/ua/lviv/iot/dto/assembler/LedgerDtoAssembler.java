package ua.lviv.iot.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.controller.LedgerController;
import ua.lviv.iot.domain.Ledger;
import ua.lviv.iot.dto.LedgerDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LedgerDtoAssembler implements RepresentationModelAssembler<Ledger, LedgerDto> {
    @Override
    public LedgerDto toModel(Ledger entity) {
        LedgerDto ledgerDto = LedgerDto.builder().id(entity.getId()).client(entity.getClient()).ordering(entity.getOrdering()).action(entity.getAction()).time(entity.getTime()).user(entity.getUser()).build();
        Link selfLink = linkTo(methodOn(LedgerController.class).getLog(ledgerDto.getId())).withSelfRel();
        ledgerDto.add(selfLink);
        return ledgerDto;
    }

    @Override
    public CollectionModel<LedgerDto> toCollectionModel(Iterable<? extends Ledger> entities) {
        CollectionModel<LedgerDto> ledgersDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(LedgerController.class).getAllLogs()).withSelfRel();
        ledgersDto.add(selfLink);
        return ledgersDto;
    }
}
