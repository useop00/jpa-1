package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    private String memberName; // 이름
    private OrderStatus orderStatus; // 주문상태
}
