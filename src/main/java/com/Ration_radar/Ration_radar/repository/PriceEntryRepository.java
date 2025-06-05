package com.Ration_radar.Ration_radar.repository;

import com.Ration_radar.Ration_radar.entities.PriceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceEntryRepository extends JpaRepository<PriceEntry , Long> {
    List<PriceEntry> findByLocation(String location);
}
