package com.apul.discountservice.model.dto;

import com.apul.discountservice.model.DiscountType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record DiscountDto(BigDecimal grossDiscount, DiscountType discountType) {

    public static void main(String[] args) {
        DiscountDto discountDto = new DiscountDto(BigDecimal.ZERO, DiscountType.PERCENTAGE);
        System.out.println(discountDto.discountType);
        System.out.println(discountDto.grossDiscount);
    }
}
