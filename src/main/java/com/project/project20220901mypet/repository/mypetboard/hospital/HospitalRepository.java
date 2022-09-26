package com.project.project20220901mypet.repository.mypetboard.hospital;

import com.project.project20220901mypet.entity.mypetboard.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
