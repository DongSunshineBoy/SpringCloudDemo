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
@ApiModel("用户删除信息实体dto")
public class TbUserDeletedHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("删除角色编码id")
    private Long userDeletedHistoryId;

    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private Long userId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date starttime;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用")
    private String userDeleted;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endtime;


}
