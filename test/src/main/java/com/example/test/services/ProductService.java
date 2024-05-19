package com.example.test.services;

import com.example.test.dto.BorrowerDto;
import com.example.test.dto.ProductsDto;
import com.example.test.dto.RulesDto;
import com.example.test.entity.ProductsDB;
import com.example.test.repositories.BorrowerRepository;
import com.example.test.repositories.ProductsRepository;
import com.example.test.repositories.RulesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService implements CRUDService<ProductsDto> {
    private final ProductsRepository productsRepository;
    private final BorrowerRepository borrowerRepository;
    private final RulesRepository rulesRepository;

    public Collection<ProductsDto> getAll() {
        log.info("Get all products");

        return productsRepository.findAll()
                .stream()
                .map(ProductService::mapToDto)
                .toList();
    }

    public ProductsDto getAllRulesByProductId(int productId) {
        log.info("Get rule by product id: {}", productId);

        Optional<ProductsDB> productsDBOptional = productsRepository.findById(productId);
        if (productsDBOptional.isEmpty()) {
            return null;
        }
        return mapToDto(productsRepository.findById(productId).orElseThrow());
    }

    private ProductsDto getProductById(int productId) {
        log.info("Get product by ID: {}", productId);

        Optional<ProductsDB> productsDBOptional = productsRepository.findById(productId);
        if (productsDBOptional.isEmpty()) {
            return null;
        }

        return mapToDto(productsRepository.findById(productId).orElseThrow());
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

    static ProductsDto mapToDto(ProductsDB productsDB) {
        ProductsDto productsDto = new ProductsDto();

        productsDto.setId(productsDB.getId());
        productsDto.setName(productsDB.getName());
        productsDto.setDuration(productsDB.getDuration());
        productsDto.setPercent(productsDB.getPercent());
        productsDto.setAmountOfCredit(productsDB.getAmountOfCredit());
        productsDto.setActive(productsDB.isActive());
        productsDto.setCreationDate(productsDB.getCreationDate());
        productsDto.setLastUpdate(LocalDateTime.now());
        productsDto.setRules(productsDB.getRulesDB()
                .stream()
                .map(RulesService::mapToDto)
                .toList());

        return productsDto;
    }

    public ProductsDB mapToEntity(ProductsDto productsDto) {
        ProductsDB productsDB = new ProductsDB();

        productsDB.setId(productsDto.getId());
        productsDB.setName(productsDto.getName());
        productsDB.setDuration(productsDto.getDuration());
        productsDB.setPercent(productsDto.getPercent());
        productsDB.setAmountOfCredit(productsDto.getAmountOfCredit());
        productsDB.setCreationDate(LocalDateTime.now());
        productsDB.setLastUpdate(LocalDateTime.now());
        productsDB.setActive(productsDto.isActive());
        productsDB.setRulesDB(productsDto.getRules()
                .stream()
                .map(RulesService::mapToEntity)
                .toList());

        return productsDB;
    }
}
