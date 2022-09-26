package com.project.project20220901mypet.service.mypetboard.hotel;

import com.project.project20220901mypet.entity.mypetboard.common.HotelImage;
import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import com.project.project20220901mypet.entity.mypetboard.hotel.HotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HotelService {

    Page<Hotel> getHotelList(Pageable pageable);

    Long insertHotel(Hotel hotel);

    Long insertRoom(HotelRoom hotelRoom);

    Hotel getHotel(Hotel hotel);

    void updateHotel(Hotel hotel);

    void deleteHotel(Hotel hotel);

    Long insertHotelImage(HotelImage hotelImage);

    HotelImage getHotelImageEntity(Long HotelSeq);

}
