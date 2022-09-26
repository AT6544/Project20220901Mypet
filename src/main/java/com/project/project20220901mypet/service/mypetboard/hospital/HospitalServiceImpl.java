package com.project.project20220901mypet.service.mypetboard.hospital;

import com.project.project20220901mypet.entity.mypetboard.common.HospitalImage;
import com.project.project20220901mypet.entity.mypetboard.hospital.Hospital;
import com.project.project20220901mypet.repository.Image.HospitalImageRepository;
import com.project.project20220901mypet.repository.mypetboard.hospital.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepo;

    private final HospitalImageRepository hospitalImageRepo;

    @Autowired
    protected HospitalServiceImpl(HospitalRepository hospitalRepo,HospitalImageRepository hospitalImageRepo) {
        this.hospitalRepo = hospitalRepo;
        this.hospitalImageRepo = hospitalImageRepo;
    }


    @Override
    public Page<Hospital> getHospitalList(Pageable pageable) {
        return hospitalRepo.findAll(pageable);
    }

    @Override
    public Long insertHospital(Hospital hospital) {
        return hospitalRepo.save(hospital).getSeq();
    }



    @Override
    public Hospital getHospital(Hospital hospital) {
        return hospitalRepo.findById(hospital.getSeq()).get();
    }

    @Override
    public void updateHospital(Hospital hospital) {

    }

    @Override
    public void deleteHospital(Hospital hospital) {

    }

    @Override
    public Long insertHospitalImage(HospitalImage hospitalImage) {

        return hospitalImageRepo.save(hospitalImage).getImageSeq();
    }

    @Override
    public HospitalImage getHospitalImageEntity(Long HospitalSeq) {

        return hospitalImageRepo.findByHospitalSeq(HospitalSeq);
    }
}
