package com.project.project20220901mypet.entity.mypetboard.hospital;

import com.project.project20220901mypet.entity.mypetboard.common.BoardCommon;
import lombok.*;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Hospital extends BoardCommon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq" )
    private Long seq;





}
