package com.example.test.controller;

import com.example.test.dto.ProductsDto;
import com.example.test.services.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final CRUDService<ProductsDto> crudService;

    @GetMapping("/products")
    public ResponseEntity<Collection<ProductsDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(crudService.getAll());
    }

    @GetMapping("/products/{id}/rules")
    public RestController<Collection<RulesDto>> getRulesForBorrower() {
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
