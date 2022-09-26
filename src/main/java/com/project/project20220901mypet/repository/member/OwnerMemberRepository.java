package com.project.project20220901mypet.repository.member;

import com.project.project20220901mypet.entity.member.OwnerMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMemberRepository extends JpaRepository<OwnerMember ,Long> {
}
