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
@ApiModel("租户历史信息实体dto")
public class TbUserAccountRoleHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @ApiModelProperty("租户角色id")
    private Long userId;

    /**
     * 租户编号
     */
    @ApiModelProperty("租户编号")
    private Long accountId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date starttime;

    /**
     * 角色编号
     */
    @ApiModelProperty("角色编号")
    private Long roleId;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endtime;

    /**
     * 用户角色租户编号
     */
    @ApiModelProperty("用户角色租户编号")
    private Long userAccountRoleId;


}
