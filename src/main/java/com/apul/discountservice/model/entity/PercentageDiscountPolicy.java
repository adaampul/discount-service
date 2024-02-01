package com.apul.discountservice.model.entity;

import com.apul.discountservice.model.DiscountType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(DiscountType.Values.PERCENTAGE)
public class PercentageDiscountPolicy extends DiscountPolicy {

}
