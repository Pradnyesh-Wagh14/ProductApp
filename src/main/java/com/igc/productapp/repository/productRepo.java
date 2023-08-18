package com.igc.productapp.repository;

import com.igc.productapp.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo extends JpaRepository<ProductEntity,Integer> {

}
