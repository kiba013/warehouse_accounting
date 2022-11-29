package com.kata.warehouse_accounting.country.service;

import com.kata.warehouse_accounting.country.model.ProductPackingDTO;
import com.kata.warehouse_accounting.country.model.ProductPackingMapper;
import com.kata.warehouse_accounting.country.repository.ProductPackingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductPackingServiceImpl implements ProductPackingService{


    private final ProductPackingRepository productPackingRepository;

    public ProductPackingServiceImpl(ProductPackingRepository productPackingRepository) {
        this.productPackingRepository = productPackingRepository;
    }

    @Override
    public List<ProductPackingDTO> getAll() {
        return productPackingRepository.findAll()
                .stream()
                .map(ProductPackingMapper.INSTANCE::PRODUCT_PACKING_ENTITY_ToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductPackingDTO getByID(Long id) {
        return ProductPackingMapper.INSTANCE
                .PRODUCT_PACKING_ENTITY_ToDTO(productPackingRepository.findById(id).orElse(null));
    }

    @Override
    public void create(ProductPackingDTO productPackingDTO) {
        productPackingRepository.save(ProductPackingMapper.INSTANCE
                .PRODUCT_PACKING_DTO_ToEntity(productPackingDTO));
    }

    @Override
    public void update(ProductPackingDTO productPackingDTO) {
        productPackingRepository.save(ProductPackingMapper.INSTANCE
                .PRODUCT_PACKING_DTO_ToEntity(productPackingDTO));
    }

    @Override
    public void remove(Long id) {
        productPackingRepository.deleteById(id);
    }
}
