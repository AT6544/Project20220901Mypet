package com.project.project20220901mypet.service.mypetboard.foodcafe;

import com.project.project20220901mypet.entity.mypetboard.common.FoodcafeImage;
import com.project.project20220901mypet.entity.mypetboard.foodcafe.Foodcafe;
import com.project.project20220901mypet.repository.Image.FoodcafeImageRepository;
import com.project.project20220901mypet.repository.mypetboard.foodcafe.FoodcafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodcafeServiceImpl implements FoodcafeService {

    private final FoodcafeRepository foodcafeRepo;

    private final FoodcafeImageRepository foodcafeImageRepo;

    @Autowired
    protected FoodcafeServiceImpl(FoodcafeRepository foodcafeRepo,FoodcafeImageRepository foodcafeImageRepo) {
        this.foodcafeRepo = foodcafeRepo;
        this.foodcafeImageRepo = foodcafeImageRepo;
    }


    @Override
    public Page<Foodcafe> getFoodcafeList(Pageable pageable) {
        return foodcafeRepo.findAll(pageable);
    }

    @Override
    public Long insertFoodcafe(Foodcafe foodcafe) {
        return foodcafeRepo.save(foodcafe).getSeq();
    }



    @Override
    public Foodcafe getFoodcafe(Foodcafe foodcafe) {
        return foodcafeRepo.findById(foodcafe.getSeq()).get();
    }

    @Override
    public void updateFoodcafe(Foodcafe foodcafe) {

    }

    @Override
    public void deleteFoodcafe(Foodcafe foodcafe) {

    }

    @Override
    public Long insertFoodcafeImage(FoodcafeImage foodcafeImage) {

        return foodcafeImageRepo.save(foodcafeImage).getImageSeq();
    }

    @Override
    public FoodcafeImage getFoodcafeImageEntity(Long FoodcafeSeq) {

        return foodcafeImageRepo.findByFoodcafeSeq(FoodcafeSeq);
    }

    @Override
    public Page<Foodcafe> getFoodcafeWhereFood(Pageable pageable, String category) {
        return foodcafeRepo.findByDetailCategoryFoodSearch(pageable,category);
    }

    public Page<Foodcafe> getFoodcafeWhereCafe(Pageable pageable,  String category) {
        return foodcafeRepo.findByDetailCategoryCafeSearch(pageable, category);
    }

    public Page<Foodcafe> getFoodcafeLikeStoreName(Pageable pageable, String storeName) {
        return foodcafeRepo.findByStoreNameLike(pageable, storeName);
    }
}
