package com.Ration_radar.Ration_radar.service;


import com.Ration_radar.Ration_radar.entities.PriceEntry;
import com.Ration_radar.Ration_radar.entities.User;
import com.Ration_radar.Ration_radar.repository.PriceEntryRepository;
import com.Ration_radar.Ration_radar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceEntryService {

    private final PriceEntryRepository priceEntryRepository;
    private final UserRepository userRepository;

    public PriceEntry savePriceEntry(PriceEntry priceEntry, String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        priceEntry.setPostedBy(user);
        return priceEntryRepository.save(priceEntry);
    }

    public List<PriceEntry> getAllPrices() {
        return priceEntryRepository.findAll();
    }

    public List<PriceEntry> getPricesByLocation(String location) {
        return priceEntryRepository.findByLocation(location);
    }
}

