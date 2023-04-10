package com.ruimind.gis.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

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
@ApiModel("日志分页实体信息")
public class TbLogCodeQueryDTO extends PageParamQueryDTO {

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
    @Length(min = 0, max = 20, message = "操作IP不能够超过0～20范围")
    private String logIp;

    /**
     * 操作内容
     */
    @ApiModelProperty("操作内容")
    @Length(min = 0, max = 255, message = "操作内容不能够超过0～255范围")
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
    @Length(min = 0, max = 10, message = "操作状态范围值不能够超过0～10范围")
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
