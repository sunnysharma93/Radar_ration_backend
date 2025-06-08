package com.Ration_radar.Ration_radar.repository;

import com.Ration_radar.Ration_radar.entities.FlipkartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlipKartRepository extends JpaRepository<FlipkartProduct,Long> {
    FlipkartProduct findBySku(String sku);
}
