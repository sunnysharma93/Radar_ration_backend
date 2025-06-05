package com.Ration_radar.Ration_radar.controller;

import com.Ration_radar.Ration_radar.entities.AlertPreference;
import com.Ration_radar.Ration_radar.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    // Set or update alert preferences for a user
    @PostMapping("/preferences/{userId}")
    public ResponseEntity<AlertPreference> setAlertPreferences(
            @PathVariable Long userId,
            @RequestBody AlertPreference preferences) {
        AlertPreference savedPref = alertService.saveOrUpdatePreferences(userId, preferences);
        return ResponseEntity.ok(savedPref);
    }

    // Get alert preferences of a user
    @GetMapping("/preferences/{userId}")
    public ResponseEntity<List<AlertPreference>> getAlertPreferences(@PathVariable Long userId) {
        List<AlertPreference> prefs = alertService.getPreferencesByUserId(userId);
        return ResponseEntity.ok(prefs);
    }

    // This could be an endpoint to trigger sending alerts manually (optional)
    @PostMapping("/send/{userId}")
    public ResponseEntity<String> sendAlerts(@PathVariable Long userId) {
        alertService.sendAlertsToUser(userId);
        return ResponseEntity.ok("Alerts sent (if any)");
    }
}
