package com.kata.warehouse_accounting.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CountryDTO {

    private Long id;

    private String shortName;

    private String longName;

    private Long digitalCode;

    private String literalCode;
}
