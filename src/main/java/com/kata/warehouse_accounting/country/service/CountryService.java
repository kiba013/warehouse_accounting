package com.kata.warehouse_accounting.country.service;

import com.kata.warehouse_accounting.country.model.CountryDTO;

import java.util.List;

public interface CountryService {

    List<CountryDTO> getAll();
    CountryDTO getByID(Long id);
    void create(CountryDTO countryDTO);
    void update(CountryDTO countryDTO);
    void deleteByID(Long id);
}
