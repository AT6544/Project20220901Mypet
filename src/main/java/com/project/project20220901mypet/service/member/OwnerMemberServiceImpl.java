package com.project.project20220901mypet.service.member;


import com.project.project20220901mypet.entity.member.OwnerMember;
import com.project.project20220901mypet.repository.member.OwnerMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerMemberServiceImpl implements OwnerMemberService {
    private final OwnerMemberRepository ownerMemberRepo;
    @Autowired
    public OwnerMemberServiceImpl(OwnerMemberRepository ownerMemberRepo) {
        this.ownerMemberRepo = ownerMemberRepo;
    }

    //호텔 가게 목록
    @Override
    public Page<OwnerMember> getOwnerMemberList(Pageable pageable){
        return ownerMemberRepo.findAll(pageable);
    }

    //hotel에서 사업자 회원 데이터 긁어오기 위해 사용


    @Override
    public void insertOwnerMember(OwnerMember ownerMember) {
        ownerMemberRepo.save(ownerMember);
    }

    @Override
    public OwnerMember getOwnerMember(OwnerMember ownerMember) {
        return ownerMemberRepo.findById(ownerMember.getOwnerMemberSeq()).get();
    }

    @Override
    public void updateOwnerMember(OwnerMember ownerMember) {

    }

    @Override
    public void deleteOwnerMember(OwnerMember ownerMember) {

    }
}
