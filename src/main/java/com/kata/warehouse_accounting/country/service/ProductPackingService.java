package com.kata.warehouse_accounting.country.service;

import com.kata.warehouse_accounting.country.model.ProductPackingDTO;

import java.util.List;

public interface ProductPackingService {

    List<ProductPackingDTO> getAll();

    ProductPackingDTO getByID(Long id);

    void create(ProductPackingDTO productPackingDTO);

    void update(ProductPackingDTO productPackingDTO);

    void remove(Long id);
}
