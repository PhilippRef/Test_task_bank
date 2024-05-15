package com.example.test.services;

import com.example.test.dto.ProductsDto;
import com.example.test.entity.ProductsDB;
import com.example.test.repositories.BorrowerRepository;
import com.example.test.repositories.ProductsRepository;
import com.example.test.repositories.RulesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        return productsRepository.findAll().stream()
                .map(ProductService::mapToDto)
                .toList();
    }

    public ProductsDto getRuleByProductId(int productId) {
        log.info("Get rule by product id: {}", productId);
        Optional<ProductsDB> productsDBOptional = productsRepository.findById(productId);
        if (productsDBOptional.isEmpty()) {
            return null;
        }
        return mapToDto(productsRepository.findById(productId).orElseThrow());
    }

    private static ProductsDto mapToDto(ProductsDB productsDB) {
        ProductsDto productsDto = new ProductsDto();

        productsDto.setId(productsDB.getId());
        productsDto.setName(productsDB.getName());
        productsDto.setDuration(productsDB.getDuration());
        productsDto.setPercent(productsDB.getPercent());
        productsDto.setAmountOfCredit(productsDB.getAmountOfCredit());
        productsDto.setCreationDate(productsDB.getCreationDate());
        productsDto.setLastUpdate(productsDB.getLastUpdate());
        productsDto.setActive(productsDB.isActive());
        productsDto.setRulesDto(productsDB.getName());

        return productsDto;
    }

}
