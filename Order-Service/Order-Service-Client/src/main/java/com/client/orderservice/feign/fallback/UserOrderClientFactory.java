package com.client.orderservice.feign.fallback;

import com.client.orderservice.feign.UserOrderClient;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOrderClientFactory implements FallbackFactory<UserOrderClient> {

    private UserOrderClient userOrderClient;

    @Autowired
    public UserOrderClientFactory(UserOrderClient userOrderClient) {
        this.userOrderClient = userOrderClient;
    }

    @Override
    public UserOrderClient create(Throwable throwable) {
        throwable.getCause();
        return userOrderClient;
    }
}
