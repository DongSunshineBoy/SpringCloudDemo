package com.ruimind.gis.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("用户实体dto")
public class TbUserCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("角色id")
    private Long userId;

    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    private String userName;

    /**
     * 登录名
     */
    @ApiModelProperty("登录名")
    private String loginName;

    /**
     * 用户姓名缩写
     */
    @ApiModelProperty("用户姓名缩写")
    private String userNameAbbr;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String loginPassword;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String userTel;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用")
    private Integer userDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date userCreateTime;

    /**
     * 创建人用户编号
     */
    @ApiModelProperty("创建人用户编号")
    private Long userCreateUserid;

    /**
     * 上次登录时间
     */
    @ApiModelProperty("上次登录时间")
    private Date lastLoginTime;

    /**
     * 组织机构编号
     */
    @ApiModelProperty("组织机构编号")
    private Integer organizationTreeId;

    /**
     * 组织结构编码
     */
    @ApiModelProperty("组织结构编码")
    private String organizationTreeCode;


}
