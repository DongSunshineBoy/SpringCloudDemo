package com.gateway.api.utils;



//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gateway.api.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    /**
     * 密钥
     */
    private static final String SECRET = "my_secret";

    /**
     * 过期时间
     **/
    private static final long EXPIRATION = 18000L;//单位为秒


    /**
     * 生成用户token,设置token超时时间
     */
    public static String createToken(User user) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = null;
        try {

            token = JWT.create().withHeader(map) // header  可以没有 有默认值

                    .withClaim("id", user.getUserId()) // payload

                    .withClaim("username", user.getUsername()) // payload

                    .withClaim("password", user.getPassword()) // payload

                    .withExpiresAt(new Date(System.currentTimeMillis() + 3000*1000)) // 指令令牌过期时间

                    .sign(Algorithm.HMAC256(user.getPassword())); // 签名

        }catch (Exception e) {
            logger.debug("create token has occur error is ", e);
            throw new RuntimeException("创建token失败!");
        }

        return token;
    }
}

