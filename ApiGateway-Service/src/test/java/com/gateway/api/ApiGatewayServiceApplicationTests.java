package com.gateway.api;

import com.gateway.api.entity.User;
import com.gateway.api.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ApiGatewayServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenerateToken() {
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        user.setUserId("123");
        String token = JwtUtils.createToken(user);
        System.out.println(token);
    }


    @Test
    public void testLog() {
        log.info("我是info");
        log.trace("我是trace");
        log.warn("我是warn");
        log.debug("我是debug");
        log.error("我是error");
    }

}
