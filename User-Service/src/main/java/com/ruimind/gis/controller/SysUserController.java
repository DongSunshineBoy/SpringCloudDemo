package com.ruimind.gis.controller;


import com.client.orderservice.feign.UserOrderClient;
import com.client.orderservice.feign.dto.UserOrderDto;
import com.ruimind.gis.dto.SysUserDto;
import com.ruimind.gis.service.SysUserService;
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
 * 用户表 前端控制器
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@RestController
@Api(tags = "用户管理")
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService userOrderService;

    @Autowired
    private UserOrderClient userOrderClient;

    @GetMapping("/saveUser")
    @ApiOperation("保存用户信息")
    public void saveOrder() {
        int ra = new Random().nextInt() * 10;
        SysUserDto userOrder = new SysUserDto();
        userOrder.setName("张三" + ra);
        userOrder.setAge(13);
        userOrderService.insert(userOrder);
    }


    @GetMapping("/getUserById/{id}")
    @ApiOperation("根据用户ID, 获取用户信息")
    public SysUserDto getOrderById(@PathVariable("id") Integer id) {
        return userOrderService.getUserById(id);
    }

    @GetMapping("/getUserOrderById/{id}")
    @ApiOperation("根据用户ID, 获取用户信息")
    public UserOrderDto getUserOrder(@PathVariable("id") Integer id) {
        return userOrderClient.getOrderById(id);
    }

}

