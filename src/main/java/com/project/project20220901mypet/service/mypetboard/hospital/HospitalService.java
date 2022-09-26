package com.project.project20220901mypet.service.mypetboard.hospital;

import com.project.project20220901mypet.entity.mypetboard.common.HospitalImage;
import com.project.project20220901mypet.entity.mypetboard.hospital.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HospitalService {
    Page<Hospital> getHospitalList(Pageable pageable);

    Long insertHospital(Hospital hospital);

    Hospital getHospital(Hospital hospital);

    void updateHospital(Hospital hospital);

    void deleteHospital(Hospital hospital);

    Long insertHospitalImage(HospitalImage hospitalImage);

    HospitalImage getHospitalImageEntity(Long HotelSeq);
}
