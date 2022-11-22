package com.kata.warehouse_accounting.country.controller;


import com.kata.warehouse_accounting.country.model.CountryDTO;
import com.kata.warehouse_accounting.country.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Api(tags = "Country Rest Controller")
@Tag(name = "Country Rest Controller", description = "Countries API")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ApiOperation(value = "Получение списка всех Стран")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получен список Страны"),
            @ApiResponse(code = 404, message = "Не найдено - Страна не найдено"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @GetMapping("/countries")
    public ResponseEntity<List<CountryDTO>> showAllCountry() {
        return ResponseEntity.ok(countryService.getAll());
    }


    @ApiOperation(value = "Получение записа по ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешно получено"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдено"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getByID(
            @ApiParam(name = "id",readOnly = true, value = "ID для CountryDTO")
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(countryService.getByID(id));
    }


    @ApiOperation(value = "Создание записи")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешно сохранена"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдена"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @PostMapping("/country")
    public ResponseEntity createCountry(
            @ApiParam(name = "CountryDTO",readOnly = true, value = "Объект CountryDTO для создание")
            @RequestBody CountryDTO countryDTO) {
        countryService.create(countryDTO);
        return ResponseEntity.ok(countryDTO);
    }


    @ApiOperation(value = "Редактирование записи")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешно обнавлена"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдена"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @PutMapping("/{id}")
    public ResponseEntity updateCountry(
            @ApiParam(name = "id",readOnly = true, value = "Объект Country для редактирования")
            @RequestBody CountryDTO countryDTO,
            @PathVariable("id") Long id) {
        countryService.update(countryDTO);
        return ResponseEntity.ok(countryDTO);
    }


    @ApiOperation(value = "Удалние записи")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешно уделена"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдена"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCountry(
            @ApiParam(name = "id",readOnly = true, value = "ID Country для удалния")
            @PathVariable("id") Long id) {
        countryService.deleteByID(id);
        return ResponseEntity.ok(id);
    }
}
