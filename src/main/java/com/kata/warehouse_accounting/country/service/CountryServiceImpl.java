package com.kata.warehouse_accounting.country.service;

import com.kata.warehouse_accounting.country.model.CountryDTO;
import com.kata.warehouse_accounting.country.model.CountryMapper;
import com.kata.warehouse_accounting.country.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<CountryDTO> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryMapper.INSTANCE::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDTO getByID(Long id) {
        return CountryMapper.INSTANCE
                .convertEntityToDto(countryRepository.findById(id).orElse(null));
    }

    @Override
    public void create(CountryDTO countryDTO) {
        countryRepository.save(CountryMapper.INSTANCE
                .convertDTOToEntity(countryDTO));
    }

    @Override
    public void update(CountryDTO countryDTO) {
        countryRepository.save(CountryMapper.INSTANCE.convertDTOToEntity(countryDTO));
    }

    @Override
    public void deleteByID(Long id) {
        countryRepository.deleteById(id);
    }
}
