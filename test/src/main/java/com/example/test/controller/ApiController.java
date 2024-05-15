package com.example.test.controller;

import com.example.test.dto.ProductsDto;
import com.example.test.dto.RulesDto;
import com.example.test.services.CRUDService;
import com.example.test.services.ProductService;
import com.example.test.services.RulesService;
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
    private final ProductService productService;
    private final RulesService rulesService;

    @GetMapping("/products")
    public ResponseEntity<Collection<ProductsDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/products/{id}/rules")
    public ResponseEntity<?> getRulesByProductId(@PathVariable int id) {
        if (productService.getRuleByProductId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message: " + "продукт с id " + id + " не существует");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productService.getRuleByProductId(id));
    }

    @PostMapping(value = "/products/{id}/rules",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addRuleForProduct(@PathVariable int id,
                                               @RequestBody RulesDto rulesDto) {
        if (productService.getRuleByProductId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message: " + "продукт с id " + id + " не существует");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rulesService.addRuleForProduct(id, rulesDto));
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
