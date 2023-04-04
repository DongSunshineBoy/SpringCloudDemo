package com.orderservice.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orderservice.orderservice.dto.UserOrderDto;
import com.orderservice.orderservice.entity.UserOrder;
import com.orderservice.orderservice.jpa.UserOrderRepository;
import com.orderservice.orderservice.mapper.UserOrderMapper;
import com.orderservice.orderservice.service.UserOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

    private UserOrderMapper userOrderMapper;

    private UserOrderRepository userOrderRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public UserOrderServiceImpl(UserOrderMapper userOrderMapper, UserOrderRepository userOrderRepository) {
        this.userOrderMapper = userOrderMapper;
        this.userOrderRepository = userOrderRepository;
    }

    public UserOrderServiceImpl(){};

    @Override
    public void insert(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public UserOrderDto getUserOrderById(Integer id) {
        UserOrder userOrder = userOrderRepository.findById(id).orElseGet(UserOrder::new);
        return mapper.map(userOrder, UserOrderDto.class);
    }
}
