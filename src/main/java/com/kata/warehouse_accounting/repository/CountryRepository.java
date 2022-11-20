package com.kata.warehouse_accounting.repository;

import com.kata.warehouse_accounting.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
