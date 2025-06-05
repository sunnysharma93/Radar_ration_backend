package com.Ration_radar.Ration_radar.controller;

import com.Ration_radar.Ration_radar.entities.SurplusPost;
import com.Ration_radar.Ration_radar.service.SurplusPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surplus")
@RequiredArgsConstructor
public class SurplusPostController {

    private final SurplusPostService surplusPostService;

    // Post a new surplus item
    @PostMapping("/post")
    public ResponseEntity<SurplusPost> postSurplus(@RequestBody SurplusPost surplusPost) {
        return ResponseEntity.ok(surplusPostService.postSurplus(surplusPost));
    }

    // Get all unclaimed surplus posts
    @GetMapping("/available")
    public ResponseEntity<List<SurplusPost>> getAvailablePosts() {
        return ResponseEntity.ok(surplusPostService.getAllAvailablePosts());
    }

    // Claim a surplus item
    @PostMapping("/claim/{id}")
    public ResponseEntity<String> claimPost(@PathVariable Long id) {
        return surplusPostService.claimSurplus(id)
                .map(post -> ResponseEntity.ok("Item claimed successfully."))
                .orElse(ResponseEntity.notFound().build());
    }
}
