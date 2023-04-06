package com.generator.commonservice.advice;

/**
 * @author dongwentao
 * @version 1.0
 * @description: 全局统一返回结果枚举类
 * @company: TODO
 */

public enum GlobalResponseResultEnum {

    //业务编码自定义, 100 ~ 1000 基本业务编码 其余根据业务需要可以自定义
    RC200(200, "操作成功"),
    RC500(500, "操作失败"),


    //业务编码自定义, 1000 ~ 2000 基本业务编码 其余根据业务需要可以自定义
    UNKNOW_HOST_USER_LOGIN_EXCEPTION(1000, "未知主机登录系统!"),
    USER_LOGIN_FAIL_EXCEPTION(1001, "用户登录失败, 请检查账号密码信息是否正确!"),

    USER_LOGIN_NOT_EXISTS_EXCEPTION(1001, "登录用户不存在, 请检查账号密码信息是否正确!"),
    USER_LOGIN_SUCCESS_EXCEPTION(200, "用户登录成功!"),
    USER_UNAUTHORITY_LOGIN(401, "用户暂无授权, 请检查登录信息!"),

    USER_UNKNOW_TOKEN_LOGIN(401, "用户暂无token请求, 请检查登录信息!"),

    //运行时异常信息
    NPE_EXCEPTION(500, "空指针异常!");


    //返回编码值
    private Integer code;

    //自定义描述消息
    private String message;

    GlobalResponseResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
