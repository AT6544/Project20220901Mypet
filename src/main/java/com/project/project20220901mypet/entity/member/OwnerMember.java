package com.project.project20220901mypet.entity.member;

import com.project.project20220901mypet.entity.mypetboard.hotel.Hotel;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OwnerMember extends MemberCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long ownerMemberSeq;

    @Column(nullable = false)
    private Long categorySeq;

    @Column(nullable = false)
    private int ownerNum;

    //조인 멤버:호텔

    @OneToMany(mappedBy = "ownerMember" )
    private List<Hotel> HotelList;




}
