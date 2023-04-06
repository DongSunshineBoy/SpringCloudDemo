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
@ApiModel("企业信息实体dto")
public class TbBusinessNameHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业信息编码")
    private Long businessNameHistoryId;

    @ApiModelProperty("企业编号")
    private Long businessId;

    @ApiModelProperty("开始时间")
    private Date starttime;

    @ApiModelProperty("企业名称")
    private String businessName;

    @ApiModelProperty("结束时间")
    private Date endtime;

}
