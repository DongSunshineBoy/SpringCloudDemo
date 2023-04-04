package com.client.orderservice.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserOrderDto implements Serializable, Comparable<UserOrderDto> {

    private static final long serialVersionUID = 1L;


    /**
     * 用户订单id
     */
    private Integer id;

    /**
     * 用户订单数量
     */
    private Integer orderNum;

    /**
     * 用户订单名称
     */
    private String oderName;

    @Override
    public int compareTo(UserOrderDto o) {
        return 0;
    }
}
