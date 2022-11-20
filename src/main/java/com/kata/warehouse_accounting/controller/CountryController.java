package com.kata.warehouse_accounting.controller;


import com.kata.warehouse_accounting.model.CountryDTO;
import com.kata.warehouse_accounting.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDTO>> showAllCountry() {
        return ResponseEntity.ok(countryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(countryService.getByID(id));
    }

    @PostMapping("/country")
    public ResponseEntity createCountry(@RequestBody CountryDTO countryDTO) {
        countryService.create(countryDTO);
        return ResponseEntity.ok(countryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCountry(@RequestBody CountryDTO countryDTO,
                                        @PathVariable("id") Long id) {
        countryService.update(countryDTO);
        return ResponseEntity.ok(countryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteByID(id);
        return ResponseEntity.ok(id);
    }
}
