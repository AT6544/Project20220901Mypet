package com.project.project20220901mypet.service.mypetboard.hotel;

import com.project.project20220901mypet.entity.mypetboard.common.HotelImage;
import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import com.project.project20220901mypet.entity.mypetboard.hotel.HotelRoom;
import com.project.project20220901mypet.repository.Image.HotelImageRepository;
import com.project.project20220901mypet.repository.mypetboard.hotel.HotelRepository;
import com.project.project20220901mypet.repository.mypetboard.hotel.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepo;
    private final HotelImageRepository hotelImageRepo;

    private final HotelRoomRepository hotelRoomRepo;

    @Autowired
    protected HotelServiceImpl(HotelRepository hotelRepo, HotelImageRepository hotelImageRepo, HotelRoomRepository hotelRoomRepo) {
        this.hotelRepo = hotelRepo;
        this.hotelImageRepo = hotelImageRepo;
        this.hotelRoomRepo = hotelRoomRepo;
    }

    @Override
    public Page<Hotel> getHotelList(Pageable pageable) {

        return hotelRepo.findAll(pageable);
    }

    @Override
    public Long insertHotel(Hotel hotel) {

       return hotelRepo.save(hotel).getSeq();
    }

    @Override
    public Long insertRoom(HotelRoom hotelRoom) {
        return hotelRoomRepo.save(hotelRoom).getRoomSeq();
    }

    @Override
    public Hotel getHotel(Hotel hotel) {

        return hotelRepo.findById(hotel.getSeq()).get();
    }

    @Override
    public void updateHotel(Hotel hotel) {

    }

    @Override
    public void deleteHotel(Hotel hotel) {

    }

    @Override
    public Long insertHotelImage(HotelImage hotelImage) {

        return hotelImageRepo.save(hotelImage).getImageSeq();
    }

    @Override
    public HotelImage getHotelImageEntity(Long HotelSeq) {

        return hotelImageRepo.findByHotelSeq(HotelSeq);
    }
}
