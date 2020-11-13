package com.kevvlvl.reactive.springreactive.controller;

import com.kevvlvl.reactive.springreactive.model.Product;
import com.kevvlvl.reactive.springreactive.model.Stock;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @GetMapping(value = "list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<Stock> listProducts() {

        Flux<Stock> stockFlux = Flux.<Stock>generate(sink -> sink.next(new Stock("XYZ", new BigDecimal(Math.random()*100)))).delayElements(Duration.ofSeconds(5));
        return stockFlux;
    }
}