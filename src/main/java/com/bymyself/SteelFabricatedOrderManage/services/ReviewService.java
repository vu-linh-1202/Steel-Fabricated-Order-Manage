package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();
    Review addReview(Review review);
}
