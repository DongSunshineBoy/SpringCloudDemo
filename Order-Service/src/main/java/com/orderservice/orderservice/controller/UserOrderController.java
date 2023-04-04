package com.orderservice.orderservice.controller;


import com.orderservice.orderservice.dto.UserOrderDto;
import com.orderservice.orderservice.entity.UserOrder;
import com.orderservice.orderservice.service.UserOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@RestController
@Api(tags = "用户订单")
@RequestMapping("/v1/user-order")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping("/saveOrder")
    @ApiOperation("保存订单信息")
    public void saveOrder() {
        int ra = new Random().nextInt() * 10;
        UserOrder userOrder = new UserOrder();
        userOrder.setOrderNum(ra);
        userOrder.setOderName("铅笔"+ra);
        userOrderService.insert(userOrder);
    }


    @GetMapping("/getOrderById/{id}")
    @ApiOperation("根据订单ID, 获取订单信息")
    public UserOrderDto getOrderById(@PathVariable("id") Integer id) {
       return userOrderService.getUserOrderById(id);
    }

}

