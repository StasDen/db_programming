package ua.lviv.iot.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Ordering;
import ua.lviv.iot.dto.OrderingDto;
import ua.lviv.iot.dto.assembler.OrderingDtoAssembler;
import ua.lviv.iot.service.OrderingService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "api/orderings")
public class OrderingController {
    @Autowired
    private OrderingService orderingService;

    @Autowired
    private OrderingDtoAssembler orderingDtoAssembler;

    @GetMapping(value = "/{orderingId}")
    public ResponseEntity<OrderingDto> getOrdering(@PathVariable Integer orderingId) {
        Ordering ordering = orderingService.findById(orderingId);
        OrderingDto orderingDto = orderingDtoAssembler.toModel(ordering);
        return new ResponseEntity<>(orderingDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<OrderingDto>> getAllOrderings() {
        List<Ordering> orderings = orderingService.findAll();
        CollectionModel<OrderingDto> orderingsDto = orderingDtoAssembler.toCollectionModel(orderings);
        return new ResponseEntity<>(orderingsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<OrderingDto> addOrdering(@RequestBody Ordering ordering) {
        Ordering newOrdering = orderingService.create(ordering);
        OrderingDto orderingDto = orderingDtoAssembler.toModel(newOrdering);
        return new ResponseEntity<>(orderingDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{orderingId}")
    public ResponseEntity<?> updateOrdering(@RequestBody Ordering uOrder, @PathVariable Integer orderingId) {
        orderingService.update(orderingId, uOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{orderingId}")
    public ResponseEntity<?> deleteOrdering(@PathVariable Integer orderingId) {
        orderingService.delete(orderingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
