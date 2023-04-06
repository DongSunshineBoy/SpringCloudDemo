package com.gateway.api.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gateway.api.advice.GlobalResponseResultEnum;
import com.gateway.api.advice.GlobalRunTimeException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class JwtInterceptor implements HandlerInterceptor, WebMvcConfigurer {

//    @Autowired
//    private ISysUserService userService;

    @Bean
    public JwtInterceptor setInterceptor() {
        return new JwtInterceptor();
    }

    private final String[] swaggerExcludes = new String[]{"/swagger-ui.html","/swagger-resources/**",
            "/webjars/**", "loginUserVerify", "error" };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Bean
    public JwtInterceptor authenticationInterceptor() {
        return new JwtInterceptor();
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String token = request.getHeader("token");

        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        if (token == null) {

            String url = request.getRequestURL().toString();

            for (String swaggerExclude : swaggerExcludes) {
                if (url.contains(swaggerExclude)) {
                    return true;
                }
            }

            throw new GlobalRunTimeException(GlobalResponseResultEnum.USER_UNKNOW_TOKEN_LOGIN.getMessage(),
                    GlobalResponseResultEnum.USER_UNKNOW_TOKEN_LOGIN.getCode());
        }

        // 获取 token 中的 user id
        String userId = null;

        try {

            DecodedJWT decode = JWT.decode(token);
            if (decode != null) {
                userId = decode.getClaim("id").asString();;
            }

        } catch (JWTDecodeException j) {
            throw new GlobalRunTimeException(GlobalResponseResultEnum.USER_UNAUTHORITY_LOGIN.getMessage(),
                    GlobalResponseResultEnum.USER_UNAUTHORITY_LOGIN.getCode());
        }

        if (userId != null) {
//            SysUser user = userService.selectUserById(userId);
//            if (user == null) {
//                throw new GlobalRunTimeException(GlobalResponseResultEnum.USER_LOGIN_FAIL_EXCEPTION.getMessage(),
//                        GlobalResponseResultEnum.USER_LOGIN_FAIL_EXCEPTION.getCode());
//            }
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("123")).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new GlobalRunTimeException(GlobalResponseResultEnum.USER_UNAUTHORITY_LOGIN.getMessage(),
                        GlobalResponseResultEnum.USER_UNAUTHORITY_LOGIN.getCode());
            }

        }

        return true;
    }

}