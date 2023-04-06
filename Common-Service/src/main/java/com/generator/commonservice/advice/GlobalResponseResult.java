package com.generator.commonservice.advice;

import lombok.Data;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author dongwentao
 * @version 1.0
 * @description: TODO
 * @company: TODO
 */
@Data
public class GlobalResponseResult <T> implements
        Serializable, Comparator<T> {

    public static final long serialVersionUID = 1L;

    //返回消息简介
    public String message;
    //返回消息编码
    public Integer code;

    //返回消息数据
    public T data;

    public static <T> GlobalResponseResult<T> success (T data){
        GlobalResponseResult<T> globalResponseResult = new GlobalResponseResult<T>();
        globalResponseResult.setCode(GlobalResponseResultEnum.RC200.getCode());
        globalResponseResult.setMessage(GlobalResponseResultEnum.RC200.getMessage());
        globalResponseResult.setData(data);
        return globalResponseResult;
    }

    public static <T> GlobalResponseResult<T> fail(Integer code, String message){
        GlobalResponseResult<T> globalResponseResult = new GlobalResponseResult<T>();
        globalResponseResult.setCode(code);
        globalResponseResult.setMessage(message);
        globalResponseResult.setData(null);
        return globalResponseResult;
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
}
