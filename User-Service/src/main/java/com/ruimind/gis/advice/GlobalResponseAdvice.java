package com.ruimind.gis.advice;


import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author dongwentao
 * @version 1.0
 * @description: TODO
 * @company: TODO
 *  打开此类可能影响现有的页面功能, 因为请求会在次类进行拦截, 返回数据类型就会被封装成前后端分离数据类型, 如果要做前后端分离就打开此类
 */

@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.getDeclaringClass().getName().contains("springfox");
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        // 如果Controller直接返回String的话，SpringBoot是直接返回，故我们需要手动转换成json。
        if(body instanceof String){
            return objectMapper.writeValueAsString(GlobalResponseResult.success(body));
        }

        if(body instanceof JSONObject){
            return body;
        }

        // GlobalResponseResult，直接返回即可。
        if(body instanceof GlobalResponseResult){
            return body;
        }

        return GlobalResponseResult.success(body);
    }
}
