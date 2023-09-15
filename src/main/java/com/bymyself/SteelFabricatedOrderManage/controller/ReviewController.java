package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.entities.Product;
import com.bymyself.SteelFabricatedOrderManage.entities.Review;
import com.bymyself.SteelFabricatedOrderManage.services.ReviewService;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<List<Review>> findAll()
    {
        List<Review> reviewList = reviewService.findAll();
        if (reviewList == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(reviewList);
    }

    @PostMapping("/addreview")
    public ResponseEntity<HashMap<String, Object>> addReview(@RequestBody Review review)
    {
        System.out.println(review);
        Review review1 = reviewService.addReview(review);
        if (review1 == null) throw new RuntimeException("Something went wrong");
        HashMap<String, Object> responseReview =new HashMap<>();
        responseReview.put("status", new String("success"));
        responseReview.put("data", review);
        return ResponseEntity.ok(responseReview);
    }
}
