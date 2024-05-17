package com.example.test.services;

import com.example.test.dto.BorrowerDto;

import java.util.Collection;
import java.util.List;

public interface CRUDService<T> {
    Collection<T> getAll();

    List<T> findProductForBorrower(BorrowerDto borrowerDto);
}
