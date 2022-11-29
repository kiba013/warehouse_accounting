package com.kata.warehouse_accounting.country.controller;

import com.kata.warehouse_accounting.country.model.ProductPackingDTO;
import com.kata.warehouse_accounting.country.service.ProductPackingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/product-packing")
@Api(tags = {"Product packing Rest Controller"})
@Tag(name = "Product packing Rest Controller", description = "Product packing API")
public class ProductPackingController {

    private final ProductPackingService productPackingService;

    public ProductPackingController(ProductPackingService productPackingService) {
        this.productPackingService = productPackingService;
    }


    @ApiOperation(value = "Получение списка")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получен список"),
            @ApiResponse(code = 404, message = "Не найдено - Фасовка не найдено"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @GetMapping("/packs")
    public ResponseEntity<List<ProductPackingDTO>> getAll() {
        return ResponseEntity.ok(productPackingService.getAll());
    }


    @ApiOperation(value = "Получение записа по ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешна получена"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдена"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductPackingDTO> getByID(
            @ApiParam(name = "id", value = "ID для ProductPackingDTO")
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(productPackingService.getByID(id));
    }


    @PostMapping("/pack")
    @ApiOperation(value = "Создание записи")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешно сохранена"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдена"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    public ResponseEntity<ProductPackingDTO> createProductPacking(
            @ApiParam(name = "Product Packing", value = "Объект Product packing для создание")
            @RequestBody ProductPackingDTO productPackingDTO) {
        productPackingService.create(productPackingDTO);
        return ResponseEntity.ok(productPackingDTO);
    }


    @ApiOperation(value = "Редактирование записи")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запись успешно обнавлена"),
            @ApiResponse(code = 404, message = "Не найдено - Запись не найдена"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductPackingDTO> updatePacking(
            @ApiParam(name = "id", readOnly = true, value = "Объект Product packing для редактирования")
            @RequestBody ProductPackingDTO productPackingDTO,
            @PathVariable("id") Long id) {
        productPackingService.update(productPackingDTO);
        return ResponseEntity.ok(productPackingDTO);
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
            @ApiParam(name = "id",readOnly = true, value = "ID Product packing для удалeния")
            @PathVariable("id") Long id) {
        productPackingService.remove(id);
        return ResponseEntity.ok(id);
    }
}
