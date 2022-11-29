package com.kata.warehouse_accounting.country.repository;

import com.kata.warehouse_accounting.country.model.ProductPacking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPackingRepository extends JpaRepository<ProductPacking, Long> {

}
