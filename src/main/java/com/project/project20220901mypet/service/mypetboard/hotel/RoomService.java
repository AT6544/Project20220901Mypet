package com.project.project20220901mypet.service.mypetboard.hotel;


import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import com.project.project20220901mypet.entity.mypetboard.hotel.HotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomService {

    Page<Hotel> getHotelRoomList(Pageable pageable);

    Long insertRoom(HotelRoom hotelroom);

    HotelRoom getRoom(HotelRoom hotelRoom);

    void updateRoom(HotelRoom hotelRoom);

    void deleteRoom(HotelRoom hotelRoom);
}
