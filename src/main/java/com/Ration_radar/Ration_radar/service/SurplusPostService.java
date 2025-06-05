package com.Ration_radar.Ration_radar.service;

import com.Ration_radar.Ration_radar.entities.SurplusPost;
import com.Ration_radar.Ration_radar.repository.SurplusPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurplusPostService {

    private final SurplusPostRepository surplusPostRepository;

    public SurplusPost postSurplus(SurplusPost surplusPost) {
        return surplusPostRepository.save(surplusPost);
    }

    public List<SurplusPost> getAllAvailablePosts() {
        return surplusPostRepository.findByClaimedFalse();
    }

    public Optional<SurplusPost> claimSurplus(Long postId) {
        Optional<SurplusPost> postOpt = surplusPostRepository.findById(postId);
        postOpt.ifPresent(post -> {
            post.setClaimed(true);
            surplusPostRepository.save(post);
        });
        return postOpt;
    }
}
