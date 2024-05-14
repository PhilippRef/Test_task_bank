package com.example.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/products")
    public ResponseEntity<Collection<ProductsDTO>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/products/{id}/rules")
    public RestController<Collection<RulesDTO>> getRulesForBorrower() {
        return null;
    }

    @PostMapping(value = "/products/{id}/rules", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<RulesDTO>> addRulesForProduct() {
        return null;
    }

    @DeleteMapping("products/{id}/rules/{id}")
    public ResponseEntity<?> deleteRulesFromProduct() {
        return null;
    }

    @PostMapping(value = "/products/apply", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductsForBorrower() {
        return null;
    }
}
