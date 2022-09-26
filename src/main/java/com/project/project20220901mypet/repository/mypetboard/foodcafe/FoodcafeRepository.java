package com.project.project20220901mypet.repository.mypetboard.foodcafe;

import com.project.project20220901mypet.entity.mypetboard.foodcafe.Foodcafe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodcafeRepository extends JpaRepository<Foodcafe, Long> {


    @Query (value = "SELECT A from Foodcafe A where A.detailCategory LIKE %?2% ")
    Page<Foodcafe> findByDetailCategoryFoodSearch(Pageable pageable, String category);

    @Query (value = "SELECT A from Foodcafe A where A.detailCategory LIKE %?2% ")
    Page<Foodcafe> findByDetailCategoryCafeSearch(Pageable pageable, String category);

    @Query (value = "SELECT A FROM Foodcafe A WHERE A.StoreName LIKE %?2% ")
    Page<Foodcafe> findByStoreNameLike(Pageable pageable, String storeName);
}
