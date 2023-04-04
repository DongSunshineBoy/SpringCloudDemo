package com.client.orderservice.feign;

import com.client.orderservice.feign.dto.UserOrderDto;
import com.client.orderservice.feign.fallback.UserOrderClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", path = "/v1/user-order" ,fallback = UserOrderClientFactory.class)
public interface UserOrderClient {

    @GetMapping("/saveOrder")
    void saveOrder();

    @GetMapping("/getOrderById/{id}")
    UserOrderDto getOrderById(@PathVariable("id") Integer id);
}
