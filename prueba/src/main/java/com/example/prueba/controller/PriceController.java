package com.example.prueba.controller;

import com.example.prueba.entity.Price;
import com.example.prueba.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public Price getPrice(@RequestParam Long productId, @RequestParam Long brandId, @RequestParam String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        return priceService.getApplicablePrice(productId, brandId, dateTime);
    }
}
