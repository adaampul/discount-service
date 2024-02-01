package com.apul.discountservice.factory;

import com.apul.discountservice.model.DiscountType;
import com.apul.discountservice.model.dto.DiscountDto;
import com.apul.discountservice.model.dto.ProductDiscountDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DiscountFactory {

    public static ProductDiscountDto productDiscountDto(String productId, List<DiscountDto> discounts) {
        return ProductDiscountDto.builder()
                .productId(productId)
                .discounts(discounts)
                .build();
    }

    public static DiscountDto discountDto(BigDecimal grossDiscount, DiscountType discountType) {
        return DiscountDto.builder()
                .grossDiscount(grossDiscount)
                .discountType(discountType)
                .build();
    }
}
