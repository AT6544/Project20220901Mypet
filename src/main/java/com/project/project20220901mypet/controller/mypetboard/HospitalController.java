package com.project.project20220901mypet.controller.mypetboard;

import com.project.project20220901mypet.entity.mypetboard.common.HospitalImage;
import com.project.project20220901mypet.entity.mypetboard.hospital.Hospital;
import com.project.project20220901mypet.service.mypetboard.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

@Controller
@RequestMapping(path = "/mypetboard/hospital")
public class HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    protected HospitalController(HospitalService hospitalService) {

        this.hospitalService = hospitalService;
    }

    @GetMapping("/insertHospital")
    public String insertHospitalView(Hospital hospital, Model model) {
        model.addAttribute("hospital", hospital);
        return "mypetboard/hospital/insertHospital";
    }

    @PostMapping("insertHospital")
    public String insertHospital(Hospital hospital, @Nullable @RequestParam("hospitalimage") MultipartFile[] hospitalimage) {
        try {
            hospital.setCreateDate(new Date());
            hospital.setBookingDate(new Date());
            Long hospitalSeq = hospitalService.insertHospital(hospital);
            List<HospitalImage> imageList = new ArrayList<>();

            for (MultipartFile file : hospitalimage) {
                if (!file.isEmpty()) {
                    HospitalImage entity = new HospitalImage(null, UUID.randomUUID().toString(), file.getContentType(), file.getName(), file.getOriginalFilename(), hospitalSeq);
                    hospitalService.insertHospitalImage(entity);
                    imageList.add(entity);
                    File newFileName = new File(entity.getUuid() + "_" + entity.getOriginalFilename());
                    file.transferTo(newFileName);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //hotelService.insertHotel(hotel);
        return "redirect:getHospitalList";
    }

    @GetMapping ("/getHospitalList")
    public String getHospitalList(Hospital hospital , Model model, @PageableDefault(size = 10 , sort = "seq", direction = Sort.Direction.ASC ) Pageable pageable) {
        System.out.println("---------check-----------");
        System.out.println(hospitalService.getHospitalList(pageable));
        System.out.println("---------check-----------");

        model.addAttribute("hospitalList", hospitalService.getHospitalList(pageable));
        model.addAttribute("previous" , pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next" , pageable.next().getPageNumber());


        return "/mypetboard/hospital/getHospitalList";
    }

    @GetMapping("/getHospital")
    public String getHospital(Hospital hospital , Model model) {

        System.out.println("---------check-----------");
        System.out.println(hospitalService.getHospital(hospital));
        System.out.println("---------check-----------");
        model.addAttribute(hospitalService.getHospital(hospital));

        HospitalImage hospitalImage = hospitalService.getHospitalImageEntity(hospital.getSeq());
        String path = "/mypetboard/hospital/image/" +hospitalImage.getUuid()+"_"+hospitalImage.getOriginalFilename();
        model.addAttribute("imageview", path);
        return "/mypetboard/hospital/getHospital";
    }

    @GetMapping("/image/{imageview}")
    public ResponseEntity<byte[]> imageView2(@PathVariable("imageview")String input_imgName) throws IOException {
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
}