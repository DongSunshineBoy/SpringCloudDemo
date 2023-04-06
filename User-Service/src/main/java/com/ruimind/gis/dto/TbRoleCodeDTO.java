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
@ApiModel("角色实体")
public class TbRoleCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @ApiModelProperty("角色id")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色缩写
     */
    @ApiModelProperty("角色缩写")
    private String roleNameAbbr;

    /**
     * 角色类型
     */
    @ApiModelProperty("角色类型")
    private Integer roleType;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private Long projectId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date roleCreateTime;

    /**
     * 创建用户编号
     */
    @ApiModelProperty("创建用户编号")
    private Long roleCreateUserid;


}
