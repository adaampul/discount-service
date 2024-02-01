package com.apul.discountservice.processor;

import com.apul.discountservice.factory.DiscountFactory;
import com.apul.discountservice.model.DiscountType;
import com.apul.discountservice.model.dto.OrderItemDto;
import com.apul.discountservice.model.dto.DiscountDto;
import com.apul.discountservice.model.entity.DiscountPolicy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Component
public class DiscountPercentageProcessor implements DiscountProcessor {
    @Override
    public boolean appliesTo(DiscountPolicy discountPolicy) {
        return Objects.nonNull(discountPolicy.getDiscountType()) && Objects.equals(discountPolicy.getDiscountType(), DiscountType.PERCENTAGE);
    }

    @Override
    public DiscountDto calculate(OrderItemDto orderItemDto, List<DiscountPolicy> discountPolicies) {
        double maxPercentDiscount = discountPolicies.stream()
                .mapToDouble(DiscountPolicy::getDiscountValue)
                .max().orElse(0);
        BigDecimal grossDiscount = orderItemDto.productPrice().grossPrice().multiply(new BigDecimal(maxPercentDiscount / 100).setScale(2, RoundingMode.HALF_UP));
        return DiscountFactory.discountDto(grossDiscount, DiscountType.PERCENTAGE);
    }

}
