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
@ApiModel("租户地图信息dto")
public class TbAccountMapinfoCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("租户地图信息ID")
    private Long accountMapinfoId;

    /**
     * 租户编号
     */
    @ApiModelProperty("租户编号")
    private Long accountId;

    /**
     * 菜单编号
     */
    @ApiModelProperty("菜单编号")
    private Long mapinfoId;

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
