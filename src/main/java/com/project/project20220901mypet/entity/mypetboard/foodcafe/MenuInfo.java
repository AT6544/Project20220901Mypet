//package com.project.project20220901mypet.entity.mypetboard.foodandcafe;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@ToString
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//
//
//public class MenuInfo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long MenuNum;
//
//    private String FoodName;
//
//    private int FoodPrice;
//
//    private Long MenuFcNum;
//
//    @ManyToOne
//    @JoinColumn(name = "FcNum(seq?)", referencedColumnName = "FcNum")
//    private FoodAndCafe foodAndCafe;
//
//}
