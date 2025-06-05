package com.Ration_radar.Ration_radar.controller;

import com.Ration_radar.Ration_radar.entities.PriceEntry;
import com.Ration_radar.Ration_radar.service.PriceEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceEntryController {

    private final PriceEntryService priceEntryService;

    @PostMapping("/add")
    public ResponseEntity<?> addPrice(@RequestBody PriceEntry priceEntry,
                                      @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("Unauthorized: Invalid or missing token");
        }

        String email = userDetails.getUsername();
        return ResponseEntity.ok(priceEntryService.savePriceEntry(priceEntry, email));
    }



    @GetMapping("/all")
    public ResponseEntity<List<PriceEntry>> getAllPrices() {
        return ResponseEntity.ok(priceEntryService.getAllPrices());
    }

    @GetMapping("/location")
    public ResponseEntity<List<PriceEntry>> getPricesByLocation(@RequestParam String location) {
        return ResponseEntity.ok(priceEntryService.getPricesByLocation(location));
    }
}
