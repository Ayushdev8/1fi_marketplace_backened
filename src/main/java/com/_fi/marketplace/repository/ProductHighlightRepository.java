package com._fi.marketplace.repository;


import com._fi.marketplace.entity.ProductHighlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductHighlightRepository extends JpaRepository<ProductHighlight, Long> {
   List<ProductHighlight> findByProductId(long id);
}
