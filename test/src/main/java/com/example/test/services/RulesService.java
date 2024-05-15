package com.example.test.services;

import com.example.test.dto.RulesDto;
import com.example.test.entity.ProductsDB;
import com.example.test.entity.RulesDB;
import com.example.test.repositories.ProductsRepository;
import com.example.test.repositories.RulesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RulesService {
    private final ProductsRepository productsRepository;
    private final RulesRepository rulesRepository;
    private final ProductService productService;

    public RulesDto addRuleForProduct(int productId, RulesDto rulesDto) {
        log.info("Create rule for product");

        RulesDB rulesDB = mapToEntity(rulesDto);
        String rulesDtoProductType = rulesDto.getProductDB();
//        ProductsDB productsDB = productsRepository
//                .findByName(rulesDtoProductType);
        ProductsDB productsDB = productsRepository.findById(productId).get();
        rulesDB.setProductsDB(productsDB);
        RulesDB createdRule = rulesRepository.save(rulesDB);

        return mapToDto(createdRule);
    }

    private static RulesDB mapToEntity(RulesDto rulesDto) {
        RulesDB rulesDB = new RulesDB();

        rulesDB.setId(rulesDto.getId());
        rulesDB.setName(rulesDto.getName());
        rulesDB.setMinSalary(rulesDto.getMinSalary());
        rulesDB.setMaxSalary(rulesDto.getMaxSalary());
        rulesDB.setCreationDate(rulesDto.getCreationDate());
        rulesDB.setLastUpdate(rulesDto.getLastUpdate());
        rulesDB.setActive(rulesDto.isActive());

        return rulesDB;
    }

    private static RulesDto mapToDto(RulesDB rulesDB) {
        RulesDto rulesDto = new RulesDto();

        rulesDto.setId(rulesDB.getId());
        rulesDto.setName(rulesDB.getName());
        rulesDto.setMinSalary(rulesDB.getMinSalary());
        rulesDto.setMaxSalary(rulesDB.getMaxSalary());
        rulesDto.setCreationDate(rulesDB.getCreationDate());
        rulesDto.setLastUpdate(rulesDB.getLastUpdate());
        rulesDto.setActive(rulesDB.isActive());
        rulesDto.setProductDB(rulesDB.getProductsDB().getName());

        return rulesDto;
    }
}
