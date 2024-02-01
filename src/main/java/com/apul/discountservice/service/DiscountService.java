package com.apul.discountservice.service;

import com.apul.discountservice.model.dto.ProductDiscountDto;
import com.apul.discountservice.model.dto.OrderDto;
import com.apul.discountservice.processor.DiscountCalculationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountCalculationFacade discountCalculationFacade;

    public List<ProductDiscountDto> calculateDiscount(OrderDto orderDto) {
        return discountCalculationFacade.calculateDiscount(orderDto);
    }
}