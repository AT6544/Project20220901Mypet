package com.project.project20220901mypet.repository.mypetboard.hotel;


import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
