package com.project.project20220901mypet.service.member;

import com.project.project20220901mypet.entity.member.OwnerMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OwnerMemberService {
    Page<OwnerMember> getOwnerMemberList(Pageable pageable);

    void insertOwnerMember(OwnerMember ownerMember);

    OwnerMember getOwnerMember(OwnerMember ownerMember);

    void updateOwnerMember(OwnerMember ownerMember);

    void deleteOwnerMember(OwnerMember ownerMember);
}
