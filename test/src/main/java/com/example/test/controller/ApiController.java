package com.example.test.controller;

import com.example.test.dto.ProductsDto;
import com.example.test.dto.RulesDto;
import com.example.test.model.Borrower;
import com.example.test.services.ProductService;
import com.example.test.services.RulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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
        if (productService.getProductByIdAndTheirRules(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message: " + "продукт с id " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByIdAndTheirRules(id));
    }

    @PostMapping(value = "/products/{id}/rules",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addRuleForProduct(@PathVariable int id,
                                               @RequestBody RulesDto rulesDto) {
        if (productService.getProductByIdAndTheirRules(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message: " + "продукт с id " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rulesService.addRuleForProduct(id, rulesDto));
    }

    @DeleteMapping("products/{productId}/rules/{ruleId}")
    public ResponseEntity<?> deleteRulesFromProduct(@PathVariable int productId,
                                                    @PathVariable int ruleId) {
        if (productService.getProductByIdAndTheirRules(productId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message: " + "продукт с id " + productId + " не найден.");
        }
        if (rulesService.getRuleByProductId(productId, ruleId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message: " + "правило с id " + ruleId
                            + " в продукте с id " + productId + " не найдено.");
        }
        rulesService.deleteRuleFromProduct(productId, ruleId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("message: " + "правило с id " + ruleId
                        + " отмечено на удаление у продукта с id " + productId);
    }

    @PostMapping(value = "/products/apply", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsDto>> getProductsForBorrower
            (@RequestBody Borrower borrower) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findProductForBorrower(borrower));
    }
}
