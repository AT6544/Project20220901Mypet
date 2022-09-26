package com.project.project20220901mypet.service.mypetboard.hotel;

import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import com.project.project20220901mypet.entity.mypetboard.hotel.HotelRoom;
import com.project.project20220901mypet.repository.mypetboard.hotel.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl  implements  RoomService{

    private final HotelRoomRepository hotelRoomRepo;

    @Autowired
    public RoomServiceImpl(HotelRoomRepository hotelRoomRepo) {
        this.hotelRoomRepo = hotelRoomRepo;
    }


    @Override
    public Page<Hotel> getHotelRoomList(Pageable pageable) {
        return null;
    }

    @Override
    public Long insertRoom(HotelRoom hotelroom) {
        return hotelRoomRepo.save(hotelroom).getRoomSeq();
    }

    @Override
    public HotelRoom getRoom(HotelRoom hotelRoom) {
        return hotelRoomRepo.findById(hotelRoom.getRoomSeq()).get();
    }

    @Override
    public void updateRoom(HotelRoom hotelRoom) {

    }

    @Override
    public void deleteRoom(HotelRoom hotelRoom) {

    }
}
