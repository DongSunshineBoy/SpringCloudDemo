package com.client.orderservice.feign.fallback;

import com.client.orderservice.feign.UserOrderClient;
import com.client.orderservice.feign.dto.UserOrderDto;
import org.springframework.stereotype.Component;

@Component
public class UserOrderClientFallback implements UserOrderClient {
    @Override
    public void saveOrder() {}

    @Override
    public UserOrderDto getOrderById(Integer id) {return null;}
}
