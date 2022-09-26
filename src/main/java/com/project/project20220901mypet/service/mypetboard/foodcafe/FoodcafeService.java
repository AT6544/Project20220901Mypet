package com.project.project20220901mypet.service.mypetboard.foodcafe;

import com.project.project20220901mypet.entity.mypetboard.common.FoodcafeImage;
import com.project.project20220901mypet.entity.mypetboard.foodcafe.Foodcafe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodcafeService {
    Page<Foodcafe> getFoodcafeList(Pageable pageable);

    Long insertFoodcafe(Foodcafe foodcafe);

    Foodcafe getFoodcafe(Foodcafe foodcafe);

    void updateFoodcafe(Foodcafe foodcafe);

    void deleteFoodcafe(Foodcafe foodcafe);

    Long insertFoodcafeImage(FoodcafeImage foodcafeImage);

    FoodcafeImage getFoodcafeImageEntity(Long HotelSeq);

    Page<Foodcafe> getFoodcafeWhereFood(Pageable pageable,String category);

    Page<Foodcafe> getFoodcafeWhereCafe(Pageable pageable, String category);

    Page<Foodcafe> getFoodcafeLikeStoreName(Pageable pageable, String storeName);
}
