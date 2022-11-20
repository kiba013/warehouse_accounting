package com.kata.warehouse_accounting.country.repository;

import com.kata.warehouse_accounting.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
