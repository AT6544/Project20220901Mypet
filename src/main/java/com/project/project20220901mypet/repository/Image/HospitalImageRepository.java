package com.project.project20220901mypet.repository.Image;

import com.project.project20220901mypet.entity.mypetboard.common.HospitalImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalImageRepository extends JpaRepository<HospitalImage, Long> {

    HospitalImage findByHospitalSeq(Long hotelSeq);
}