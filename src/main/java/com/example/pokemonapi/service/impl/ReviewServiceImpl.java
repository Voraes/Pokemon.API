package com.example.pokemonapi.service.impl;



import com.example.pokemonapi.dto.ReviewDto;
import com.example.pokemonapi.repository.ReviewRepository;
import com.example.pokemonapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    private final ReviewRepository reviewRepository;

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        return null;
    }
}
