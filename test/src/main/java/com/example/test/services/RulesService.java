package com.example.test.services;

import com.example.test.dto.ProductsDto;
import com.example.test.dto.RulesDto;
import com.example.test.entity.ProductsDB;
import com.example.test.entity.RulesDB;
import com.example.test.repositories.ProductsRepository;
import com.example.test.repositories.RulesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RulesService {
    private final ProductsRepository productsRepository;
    private final RulesRepository rulesRepository;
    private final ProductService productService;

    public RulesDto addRuleForProduct(int productId, RulesDto rulesDto) {
        log.info("Create rule for product");

        ProductsDB productsDB = productService.mapToEntity(getProductById(productId));
        RulesDB rulesDB = mapToEntity(rulesDto);
//        String rulesDtoProductType = rulesDto.getProductDB();
//        ProductsDB productsDB = productsRepository
//                .findByName(rulesDtoProductType);
        rulesDB.setProductsDB(productsDB);
        rulesDB.setCreationDate(LocalDateTime.now());
        rulesDB.setLastUpdate(LocalDateTime.now());
        rulesDB.setActive(true);
        RulesDB createdRule = rulesRepository.save(rulesDB);

        return mapToDto(createdRule);
    }

    public String deleteRuleFromProduct(int productId, int ruleId) {
        log.info("Delete rule from product");

        ProductsDB productsDB = productService.mapToEntity(getProductById(productId));

//        RulesDB rulesDB = productsDB.getRulesDB().stream()
//                .filter(r -> r.getId().equals(ruleId))
//                .findFirst()
//                .orElseThrow(() -> new EntityNotFoundException
//                        ("Правило с id " + ruleId + " не найдено."));

        RulesDB rulesDB = mapToEntity(getRuleById(ruleId));

        rulesDB.setActive(false);
        rulesDB.setLastUpdate(LocalDateTime.now());
        rulesRepository.save(rulesDB);

        return null;
    }

    public String deleteRuleById(int id) {
        log.info("Delete rule by ID: {}", id);

        Optional<RulesDB> rulesDBOptional = rulesRepository.findById(id);
        if (rulesDBOptional.isEmpty()) {
            return "message: " + "правило с id " + id + " не найдено.";
        }
        rulesRepository.deleteById(id);
        return null;
    }

    static RulesDB mapToEntity(RulesDto rulesDto) {
        RulesDB rulesDB = new RulesDB();

        rulesDB.setId(rulesDto.getId());
        rulesDB.setName(rulesDto.getName());
        rulesDB.setMinSalary(rulesDto.getMinSalary());
        rulesDB.setMaxSalary(rulesDto.getMaxSalary());
        rulesDB.setActive(rulesDto.isActive());
        rulesDB.setCreationDate(LocalDateTime.now());

        return rulesDB;
    }

    static RulesDto mapToDto(RulesDB rulesDB) {
        RulesDto rulesDto = new RulesDto();

        rulesDto.setId(rulesDB.getId());
        rulesDto.setName(rulesDB.getName());
        rulesDto.setMinSalary(rulesDB.getMinSalary());
        rulesDto.setMinSalary(rulesDB.getMinSalary());
        rulesDto.setMaxSalary(rulesDB.getMaxSalary());
        rulesDto.setActive(rulesDB.isActive());
        rulesDto.setProductDB(rulesDB.getProductsDB().getName());
        rulesDto.setCreationDate(LocalDateTime.now());

        return rulesDto;
    }

    private ProductsDto getProductById(int productId) {
        log.info("Get product by ID: {}", productId);

        Optional<ProductsDB> productsDBOptional = productsRepository.findById(productId);
        if (productsDBOptional.isEmpty()) {
            return null;
        }

        return productService.mapToDto(productsRepository.findById(productId).orElseThrow());
    }

    public RulesDto getRuleById(int ruleId) {
        log.info("Get rule by ID: {}", ruleId);

        Optional<RulesDB> rulesDBOptional = rulesRepository.findById(ruleId);
        if (rulesDBOptional.isEmpty()) {
            return null;
        }

        return mapToDto(rulesRepository.findById(ruleId).orElseThrow());
    }
}
