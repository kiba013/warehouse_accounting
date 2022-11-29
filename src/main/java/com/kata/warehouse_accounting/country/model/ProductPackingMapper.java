package com.kata.warehouse_accounting.country.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPackingMapper {

    ProductPackingMapper INSTANCE = Mappers.getMapper(ProductPackingMapper.class);

    ProductPacking PRODUCT_PACKING_DTO_ToEntity(ProductPackingDTO productPackingDTO);

    ProductPackingDTO PRODUCT_PACKING_ENTITY_ToDTO(ProductPacking productPacking);

}
