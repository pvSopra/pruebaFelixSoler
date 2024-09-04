package com.example.prueba.service;

import com.example.prueba.entity.Price;
import com.example.prueba.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public Price getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                productId, brandId, date, date);
        return prices.isEmpty() ? null : prices.get(0);
    }
}
