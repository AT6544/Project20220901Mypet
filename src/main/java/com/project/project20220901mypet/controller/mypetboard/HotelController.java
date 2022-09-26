package com.project.project20220901mypet.controller.mypetboard;

import com.project.project20220901mypet.entity.member.OwnerMember;
import com.project.project20220901mypet.entity.mypetboard.common.HotelImage;
import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import com.project.project20220901mypet.service.member.OwnerMemberService;
import com.project.project20220901mypet.service.mypetboard.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
 * * Board domain CONTROLLER
 * @Param String HTML에서 받아온 데이터
 * @return String HTML 파일과 연결을 위해 사용(ViewResolber)
 * @ author(작성자) 김명훈
 * @version 20220808.0.0.1
 */


@Controller
@RequestMapping(path = "/mypetboard/hotel")
public class HotelController {
    private final HotelService hotelService;
    private final OwnerMemberService ownerMemberService;


    //생성자 주입
    @Autowired
    protected HotelController(HotelService hotelService, OwnerMemberService ownerMemberService) {

        this.hotelService = hotelService;
        this.ownerMemberService = ownerMemberService;


    }
    @GetMapping("/insertHotel")
    public String insertHotelView(Hotel hotel, Model model , OwnerMember ownerMember) {
        //model.addAttribute("ownerMember", ownerMemberService.getOwnerMember(ownerMember));


        model.addAttribute("hotel" , hotel);
        return "mypetboard/hotel/insertHotel";
    }
    //사업자회원 테이블에서 OwnerMemberseq, Categoryseq 값을 호텔테이블로 가져와야함
    @PostMapping("/insertHotel")
    public String insertHotel(Hotel hotel, @Nullable@RequestParam("hotelimage")MultipartFile[] hotelimage) {

        try{
            hotel.setCreateDate(new Date());
            hotel.setBookingDate(new Date());
            Long hotelSeq = hotelService.insertHotel(hotel);
            List<HotelImage> imageList = new ArrayList<>();

            for(MultipartFile file : hotelimage) {
                if(!file.isEmpty()){
                    HotelImage entity = new HotelImage(null, UUID.randomUUID().toString(),file.getContentType(), file.getName(), file.getOriginalFilename(), hotelSeq);
                    hotelService.insertHotelImage(entity);
                    imageList.add(entity);
                    File newFileName = new File(entity.getUuid()+ "_" + entity.getOriginalFilename());
                    file.transferTo(newFileName);

                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //hotelService.insertHotel(hotel);
        return "redirect:getHotelList";
    }
    @GetMapping("/image/{imageview}")
    public ResponseEntity<byte[]> imageView(@PathVariable("imageview")String input_imgName) throws IOException {
        //ResponseEntity<Byte[]>:http 프로토콜을 통해서 byte 데이터를 전달하는 객체 , byte(소문자 = 기본타입)
        //@PathVariable: URL주소의 값을 받아옴
        String path = "C:/Users/admin/Desktop/MYPET/Project20220901Mypet1 base/src/main/resources/commonImage/" +input_imgName;
        //데이터(이미지)를 전송 하기 위한 객체로써 java에서는 항상 데이터를 스트림 타입으로 전달
        //객체(데이터 저장) :String,int,double
        //String객체는 파일을 컴퓨터가 cpu에서 바로 읽어 들일수 있도록 하는 갳체
        InputStream fis = new FileInputStream(path);
        //Bufferd : cpu에서 데이터를 읽어 올떄 메모리와 캐시 사이에서 Cpu와의 속도 차이를 줄이기 위한 중간 저장 위치
        BufferedInputStream bis =  new BufferedInputStream(fis);
        //byte 배열로 변환
        //HTTP프로토콜은 바이트 단위(배열)로 주고 받음
        byte[] imgByteArr = bis.readAllBytes();
        fis.close();
        //HTTP 프로토콜은 바이트 배열로 데이터를 주고 받기 때문에 Stream이나 버퍼를 통해 변환
        return new ResponseEntity<byte[]>(imgByteArr , HttpStatus.OK);

    }


    //@PageableDefault(size = 10 * 한페이지에 10개출력 , sort = "HotelSeq * HotelSeq기준으로 오름차순 청렬) pageable 페이징처리
    @GetMapping ("/getHotelList")
    public String getHotelList(Hotel hotel , Model model, @PageableDefault(size = 10 , sort = "Seq", direction = Sort.Direction.ASC ) Pageable pageable) {
        System.out.println("---------check-----------");
        System.out.println(hotelService.getHotelList(pageable));
        System.out.println("---------check-----------");

        model.addAttribute("hotelList", hotelService.getHotelList(pageable));
        model.addAttribute("previous" , pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next" , pageable.next().getPageNumber());


        return "/mypetboard/hotel/getHotelList";
    }
    @GetMapping("/getHotel")
    public String getHotel(Hotel hotel , Model model) {

        System.out.println("---------check-----------");
        System.out.println(hotelService.getHotel(hotel));
        System.out.println("---------check-----------");
        model.addAttribute(hotelService.getHotel(hotel));

        HotelImage hotelImage = hotelService.getHotelImageEntity(hotel.getSeq());
        String path = "/mypetboard/hotel/image/" +hotelImage.getUuid()+"_"+hotelImage.getOriginalFilename();
        model.addAttribute("imageview", path);
        return "/mypetboard/hotel/getHotel";
    }

}
