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
@ApiModel("日志实体信息")
public class TbLogCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("日志编号")
    private Long logId;

    /**
     * 操作ip
     */
    @ApiModelProperty("操作ip")
    private String logIp;

    /**
     * 操作内容
     */
    @ApiModelProperty("操作内容")
    private String logContext;

    /**
     * 操作时间
     */
    @ApiModelProperty("操作时间")
    private Date logDatetime;

    /**
     * 操作状态
     */
    @ApiModelProperty("操作状态")
    private String loginStatus;

    /**
     * 日志类型
     */
    @ApiModelProperty("日志类型")
    private Integer logType;

    /**
     * 操作用户编号
     */
    @ApiModelProperty("操作用户编号")
    private Long logOperateUserid;


}
