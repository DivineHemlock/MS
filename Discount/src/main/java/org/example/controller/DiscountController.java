package org.example.controller;

import org.example.entity.Discount;
import org.example.repository.DiscountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountRepository discountRepository;

    public DiscountController(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @GetMapping("/{couponName}")
    public ResponseEntity<Discount> getDiscount(@PathVariable("couponName") String couponName) {
        Discount discount = discountRepository.findByCouponName(couponName);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Discount> registerDiscount(@RequestBody Discount discount) {
        Discount discount1 = discountRepository.save(discount);
        return new ResponseEntity<>(discount, HttpStatus.CREATED);
    }
}
