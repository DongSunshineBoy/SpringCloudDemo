package com.orderservice.orderservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel("用户订单api")
public class UserOrderDto implements Serializable, Comparable<UserOrderDto> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户订单ID")
    private Integer id;

    /**
     * 用户订单数量
     */
    @ApiModelProperty("用户订单数量")
    private Integer orderNum;

    /**
     * 用户订单名称
     */
    @ApiModelProperty("用户订单名称")
    private String oderName;

    @Override
    public int compareTo(UserOrderDto o) {
        return 0;
    }
}
