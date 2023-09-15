package com.bymyself.SteelFabricatedOrderManage.repository;

import com.bymyself.SteelFabricatedOrderManage.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT avg(star) from Review where p_id=(:pid) group by p_id")
    Double getAverageStar(@Param("pid") int pid);
    Review save(Review review);
}
