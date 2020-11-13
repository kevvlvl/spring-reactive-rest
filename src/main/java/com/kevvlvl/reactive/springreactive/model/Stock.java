package com.kevvlvl.reactive.springreactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Stock {

    private String symbol;
    private BigDecimal price;
}
