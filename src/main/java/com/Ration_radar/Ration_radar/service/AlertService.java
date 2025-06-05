package com.Ration_radar.Ration_radar.service;

import com.Ration_radar.Ration_radar.entities.AlertPreference;
import com.Ration_radar.Ration_radar.entities.User;
import com.Ration_radar.Ration_radar.repository.AlertPreferenceRepository;
import com.Ration_radar.Ration_radar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertPreferenceRepository alertPreferenceRepository;
    private final UserRepository userRepository;

    public AlertPreference saveOrUpdatePreferences(Long userId, AlertPreference preference) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        preference.setUser(user);
        return alertPreferenceRepository.save(preference);
    }

    public List<AlertPreference> getPreferencesByUserId(Long userId) {
        return alertPreferenceRepository.findByUserId(userId);
    }

    public void sendAlertsToUser(Long userId) {
        // Logic to send alert notifications
        // For example, check latest PriceEntry and compare with preferences
        // Send email, push notification, etc.
    }
}
