package com.kata.warehouse_accounting.country.model;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country convertDTOToEntity(CountryDTO countryDTO);
    CountryDTO convertEntityToDto(Country country);
}
