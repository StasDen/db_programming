package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.domain.Ordering;
import ua.lviv.iot.dto.OrderingDto;
import ua.lviv.iot.dto.assembler.OrderingDtoAssembler;
import ua.lviv.iot.service.OrderingStoredProcedureService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orderings")
public class OrderingStoredProcedureController {
    @Autowired
    OrderingStoredProcedureService orderingStoredProcedureService;

    @Autowired
    OrderingDtoAssembler orderingDtoAssembler;

    @GetMapping(value = "/cost/{cost}")
    public ResponseEntity<CollectionModel<OrderingDto>> getOrderingsAfterCost(@PathVariable Integer cost) {
        List<Ordering> orderings = orderingStoredProcedureService.getOrderingsAfterCost(cost);
        CollectionModel<OrderingDto> orderingsDto = orderingDtoAssembler.toCollectionModel(orderings);
        return new ResponseEntity<>(orderingsDto, HttpStatus.OK);
    }

    @GetMapping(value = "/cost/number/{cost}")
    public ResponseEntity<Integer> getNumOfOrderingsAfterCost(@PathVariable Integer cost) {
        Integer orderingsNum = orderingStoredProcedureService.getNumOfOrderingsAfterCost(cost);
        return new ResponseEntity<>(orderingsNum, HttpStatus.OK);
    }
}
