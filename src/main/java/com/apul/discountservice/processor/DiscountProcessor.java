package com.apul.discountservice.processor;

import com.apul.discountservice.model.dto.DiscountDto;
import com.apul.discountservice.model.dto.OrderItemDto;
import com.apul.discountservice.model.entity.DiscountPolicy;

import java.util.List;

public interface DiscountProcessor {

    boolean appliesTo(DiscountPolicy discountPolicy);

    DiscountDto calculate(OrderItemDto orderItemDto, List<DiscountPolicy> discountPolicies);
}
