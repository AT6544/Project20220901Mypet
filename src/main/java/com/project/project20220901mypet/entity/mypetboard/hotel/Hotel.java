package com.project.project20220901mypet.entity.mypetboard.hotel;

import com.project.project20220901mypet.entity.member.OwnerMember;
import com.project.project20220901mypet.entity.mypetboard.common.Address;
import com.project.project20220901mypet.entity.mypetboard.common.BoardCommon;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Hotel extends BoardCommon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq" )
    private Long seq;


    private Long ownerMemberSeq;


    private Long categorySeq;

    //조인 외래키 설정 1:N  양방향 매핑 참조삭제제(호텔:룸)
    @OneToMany(mappedBy = "hotel" )
    private List<HotelRoom> HRoomList;

    //조인 사업자회원:호텔
    @ManyToOne
    @JoinColumn(referencedColumnName = "ownerMemberSeq")
    private OwnerMember ownerMember;

}
