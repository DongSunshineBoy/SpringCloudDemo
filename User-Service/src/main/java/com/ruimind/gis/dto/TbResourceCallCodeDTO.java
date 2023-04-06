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
@ApiModel("资源实体")
public class TbResourceCallCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("资源id")
    private Long resourceCallId;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String callName;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String url;

    /**
     * 操作时间
     */
    @ApiModelProperty("操作时间")
    private Date createDatetime;

    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private Long userId;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private Long projectId;


}
