package com.project.project20220901mypet.controller.member;

import com.project.project20220901mypet.entity.member.OwnerMember;
import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import com.project.project20220901mypet.service.member.OwnerMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(path = "/member/ownermember")
public class OwnerMemberControlller {

    private final OwnerMemberService ownerMemberService;

    @Autowired
    public OwnerMemberControlller(OwnerMemberService ownerMemberService) {
        this.ownerMemberService = ownerMemberService;
    }
    @GetMapping("/insertOwnerMember")
    public String insertOwnerMemberView(Hotel hotel, Model model , OwnerMember ownerMember) {

        return "member/ownermember/insertOwnerMember";
    }
    @PostMapping("/insertOwnerMember")
    public String insertOwnerMember(OwnerMember ownerMember) {
        ownerMember.setCreateDate(new Date());
        ownerMemberService.insertOwnerMember(ownerMember);
        return "./index";
    }



}
