package com.project.project20220901mypet.entity.mypetboard.hotel;

import com.project.project20220901mypet.entity.mypetboard.common.BoardCommon;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomSeq;

    //외래키 설정
    @ManyToOne
    @JoinColumn(name = "seq", referencedColumnName = "seq")
    private Hotel hotel;

    @Column(nullable = false)
    private String roomName;

    @Column(nullable = false)
    private String roomInfo;

    @Column(nullable = false)
    private String roomType;

    private Long R_HotelSeq;





}
