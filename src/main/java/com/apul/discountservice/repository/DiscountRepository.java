package com.apul.discountservice.repository;

import com.apul.discountservice.model.entity.DiscountPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountRepository extends JpaRepository<DiscountPolicy, Long> {

    List<DiscountPolicy> findByProductId(String productId);

}