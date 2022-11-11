package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.DiscountDto;
import ua.lviv.iot.dto.assembler.DiscountDtoAssembler;
import ua.lviv.iot.service.DiscountService;
import ua.lviv.iot.domain.Discount;

import java.util.List;

@RestController
@RequestMapping(value = "/api/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @Autowired
    private DiscountDtoAssembler discountDtoAssembler;

    @GetMapping(value = "/{discountId}")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable Integer discountId) {
        Discount discount = discountService.findById(discountId);
        DiscountDto discountDto = discountDtoAssembler.toModel(discount);
        return new ResponseEntity<>(discountDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<DiscountDto>> getAllDiscounts() {
        List<Discount> discounts = discountService.findAll();
        CollectionModel<DiscountDto> discountsDto = discountDtoAssembler.toCollectionModel(discounts);
        return new ResponseEntity<>(discountsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DiscountDto> addDiscount(@RequestBody Discount discount) {
        Discount newDiscount = discountService.create(discount);
        DiscountDto discountDto = discountDtoAssembler.toModel(newDiscount);
        return new ResponseEntity<>(discountDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{discountId}")
    public ResponseEntity<?> updateDiscount(@RequestBody Discount uDiscount, @PathVariable Integer discountId) {
        discountService.update(discountId, uDiscount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{discountId}")
    public ResponseEntity<?> deleteDiscount(@PathVariable Integer discountId) {
        discountService.delete(discountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "discount/{discountName}")
    public ResponseEntity<DiscountDto> getDiscountPercentageByHolidayName(@PathVariable String discountName) {
        Discount discount = discountService.findDiscountByName(discountName);
        DiscountDto discountDto = discountDtoAssembler.toModel(discount);
        return new ResponseEntity<>(discountDto, HttpStatus.OK);
    }
}
