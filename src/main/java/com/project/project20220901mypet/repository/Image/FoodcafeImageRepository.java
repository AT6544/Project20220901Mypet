package com.project.project20220901mypet.repository.Image;

import com.project.project20220901mypet.entity.mypetboard.common.FoodcafeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodcafeImageRepository extends JpaRepository<FoodcafeImage, Long> {

    FoodcafeImage findByFoodcafeSeq(Long hotelSeq);
}