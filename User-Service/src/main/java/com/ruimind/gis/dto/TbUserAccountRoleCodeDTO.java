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
 * @since 2023-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("租户用户角色")
public class TbUserAccountRoleCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty(name = "user_account_role_id")
    private Long userAccountRoleId;

    /**
     * 用户编号
     */
    @ApiModelProperty(name = "用户编号")
    private Long userId;

    /**
     * 租户编号
     */
    @ApiModelProperty("租户编号")
    private Long accountId;

    /**
     * 角色编号
     */
    @ApiModelProperty("角色编号")
    private Long roleId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 创建用户编号
     */
    @ApiModelProperty("创建用户编号")
    private Long createUserid;
}
