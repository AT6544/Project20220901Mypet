package com.project.project20220901mypet.repository.mypetboard.hotel;

import com.project.project20220901mypet.entity.mypetboard.hotel.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

}
