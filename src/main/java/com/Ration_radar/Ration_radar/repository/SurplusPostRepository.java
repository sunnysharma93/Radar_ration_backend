package com.Ration_radar.Ration_radar.repository;

import com.Ration_radar.Ration_radar.entities.SurplusPost;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurplusPostRepository extends JpaRepository<SurplusPost , Long> {
    List<SurplusPost> findByClaimedFalse();
}
