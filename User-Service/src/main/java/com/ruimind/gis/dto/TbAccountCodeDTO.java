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
@ApiModel("租户实体dto")
public class TbAccountCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("租户id")
    private Long accountId;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private Long projectId;

    /**
     * 企业编号
     */
    @ApiModelProperty("企业编号")
    private Long businessId;

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
