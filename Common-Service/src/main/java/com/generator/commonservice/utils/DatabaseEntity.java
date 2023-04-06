package com.generator.commonservice.utils;

import lombok.Data;

/**
 * 数据库信息类
 */
@Data
public class DatabaseEntity {

    //构建代码所属模块名称
    private String moduleName;
    //构建代码所属包名
    private String packageName;

    //生成代码作者名称
    private String authorName;

    //构建代码数据库url
    private String url;

    //数据库密码
    private String pwd;

    //数据库账号
    private String uname;

    //驱动
    private String driverName;
}
