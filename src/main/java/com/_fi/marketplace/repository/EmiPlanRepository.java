package com._fi.marketplace.repository;

import com._fi.marketplace.entity.EmiPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmiPlanRepository extends JpaRepository<EmiPlan,Long> {
    List<EmiPlan> findByProductId(Long productId);
}
