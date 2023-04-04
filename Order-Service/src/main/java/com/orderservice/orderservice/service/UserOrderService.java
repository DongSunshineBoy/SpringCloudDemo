package com.orderservice.orderservice.service;

import com.orderservice.orderservice.dto.UserOrderDto;
import com.orderservice.orderservice.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
public interface UserOrderService extends IService<UserOrder> {

    void insert(UserOrder userOrder);

    UserOrderDto getUserOrderById(Integer id);

}
