package com.example.test.services;

import com.example.test.dto.BorrowerDto;
import com.example.test.dto.ProductsDto;
import com.example.test.dto.RulesDto;
import com.example.test.entity.BorrowerDB;
import com.example.test.entity.ProductsDB;
import com.example.test.entity.RulesDB;
import com.example.test.repositories.BorrowerRepository;
import com.example.test.repositories.ProductsRepository;
import com.example.test.repositories.RulesRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService implements CRUDService<ProductsDto> {
    private final ProductsRepository productsRepository;
    private final BorrowerRepository borrowerRepository;
    private final RulesRepository rulesRepository;

    public Collection<ProductsDto> getAll() {
        log.info("Get all products");
        return productsRepository.findAll().stream()
                .map(ProductService::mapToDto)
                .toList();
    }

    public ProductsDto getRuleByProductId(int productId) {
        log.info("Get rule by product id: {}", productId);

        ProductsDB productsDB = productsRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException
                        ("Продукт с id " + productId + " не найден."));
//        Optional<ProductsDB> productsDBOptional = productsRepository.findById(productId);
//        if (productsDBOptional.isEmpty()) {
//            return null;
//        }
//        return mapToDto(productsRepository.findById(productId).orElseThrow());
        return mapToDto(productsDB);
    }

    @Override
    public List<ProductsDto> findProductForBorrower(BorrowerDto borrowerDto) {
        log.info("Find products for borrower: {}", borrowerDto);

        int borrowerSalary = borrowerDto.getSalary();
        int borrowerClaim = borrowerDto.getClaim();
        boolean borrowerIsDebtor = borrowerDto.isDebtor();

        List<ProductsDto> productsList = new ArrayList<>();
        Collection<ProductsDto> allProducts = getAll();
        List<RulesDto> allRules = rulesRepository.findAll().stream()
                .map(RulesService::mapToDto)
                .toList();

        for (var product : allProducts) {
            for (var rule : allRules) {
                if ((borrowerSalary > rule.getMaxSalary() && !borrowerIsDebtor) ||
                        !borrowerIsDebtor ||
                        borrowerSalary > rule.getMinSalary()) {
                    productsList.add(product);
                }
            }
        }

        return productsList;
    }

    private static ProductsDto mapToDto(ProductsDB productsDB) {
        ProductsDto productsDto = new ProductsDto();

        productsDto.setId(productsDB.getId());
        productsDto.setName(productsDB.getName());
        productsDto.setDuration(productsDB.getDuration());
        productsDto.setPercent(productsDB.getPercent());
        productsDto.setAmountOfCredit(productsDB.getAmountOfCredit());
        productsDto.setActive(productsDB.isActive());
        productsDto.setCreationDate(LocalDateTime.now());
        productsDto.setRules(productsDB.getRulesDB()
                .stream()
                .map(RulesService::mapToDto)
                .toList());

        return productsDto;
    }

}
