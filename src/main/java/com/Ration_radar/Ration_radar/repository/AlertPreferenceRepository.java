package com.Ration_radar.Ration_radar.repository;

import com.Ration_radar.Ration_radar.entities.AlertPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertPreferenceRepository extends JpaRepository<AlertPreference, Long> {
    List<AlertPreference> findByUserId(Long userId);
}
