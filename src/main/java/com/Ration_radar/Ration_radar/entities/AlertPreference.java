package com.Ration_radar.Ration_radar.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName; // e.g. "rice", "wheat"

    private double targetPrice; // Alert if price <= this

    @ManyToOne
    private User user;
}
