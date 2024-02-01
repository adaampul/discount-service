package com.apul.discountservice.processor;

import com.apul.discountservice.factory.DiscountFactory;
import com.apul.discountservice.model.dto.OrderDto;
import com.apul.discountservice.model.dto.OrderItemDto;
import com.apul.discountservice.model.dto.ProductDiscountDto;
import com.apul.discountservice.repository.DiscountRepository;
import com.apul.discountservice.model.dto.DiscountDto;
import com.apul.discountservice.model.entity.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DiscountCalculationFacade {

    private final DiscountRepository discountRepository;
    private final List<DiscountProcessor> discountProcessors;

    public List<ProductDiscountDto> calculateDiscount(OrderDto orderDto) {
        List<ProductDiscountDto> result = new LinkedList<>();
        orderDto.orderItems().forEach(orderItem -> result.add(DiscountFactory.productDiscountDto(orderItem.productId(), calculateDiscountsForProduct(orderItem))));
        return result;
    }

    private List<DiscountDto> calculateDiscountsForProduct(OrderItemDto orderItemDto) {
        List<DiscountDto> discounts = new LinkedList<>();
        List<DiscountPolicy> discountPolicies = discountRepository.findByProductId(orderItemDto.productId());
        discountProcessors.forEach(discountProcessor -> {
            List<DiscountPolicy> appliesTo = discountPolicies.stream()
                    .filter(discountProcessor::appliesTo)
                    .toList();

            if (!CollectionUtils.isEmpty(appliesTo)) {
                discounts.add(discountProcessor.calculate(orderItemDto, appliesTo));
            }
        });
        return discounts;
    }

}
