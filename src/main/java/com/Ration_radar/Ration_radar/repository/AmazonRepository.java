package com.Ration_radar.Ration_radar.repository;


import com.Ration_radar.Ration_radar.entities.AmazonProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmazonRepository extends JpaRepository<AmazonProduct, Long> {

    AmazonProduct findBySku(String sku);

}
