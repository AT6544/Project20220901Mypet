package com.project.project20220901mypet.repository.Image;

import com.project.project20220901mypet.entity.mypetboard.common.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, Long> {

      HotelImage findByHotelSeq(Long hotelSeq);
}
