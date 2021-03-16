package com.jeongmu.springstudy1.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order_detail 테이블에 연결
@ToString(exclude = {"user","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1
    // hibernate를 통한 연관관계 매핑 시 객체 이름을 매핑해줘야함
    // Long 타입 Id -> 테이블 객체
    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

}