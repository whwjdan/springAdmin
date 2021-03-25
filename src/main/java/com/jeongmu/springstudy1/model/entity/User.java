package com.jeongmu.springstudy1.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroupList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private String unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

    // 1:N
    // LAZY = 지연로딩, EAGER = 즉시로딩

    //LAZY = SELECT * FROM item where id = ?
    // orderDetailList 변수에 대해 get 메서드를 싱행하지 않는 이상
    // 연관관계가 설정된 테이블에 대해 select를 하지 않겠다.

    //EAGER = 1:1에서만
    // 성능 이슈 혹은 데이터를 불러오지 못 할 가능성 지나친 Join, Join으로 인한 데이터 나오지 않음
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // JOIN item item0_ left outer join order_detail ~~~ left outer join ~~


    // mappedBy = "user" orderDetail의 객체 이름과 동일
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    //private List<OrderDetail> orderDetailList;
}
