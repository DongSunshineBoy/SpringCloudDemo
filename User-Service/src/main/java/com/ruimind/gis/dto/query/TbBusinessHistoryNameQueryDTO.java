package com.ruimind.gis.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("企业分页信息实体dto")
public class TbBusinessHistoryNameQueryDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业信息编码")
    @ApiParam("企业信息编码")
    private Long businessNameHistoryId;

    @ApiModelProperty("企业编号")
    @ApiParam("企业信息编码")
    private Long businessId;

    @ApiModelProperty("开始时间")
    @ApiParam("企业信息编码")
    private Date starttime;

    @ApiModelProperty("企业名称")
    @ApiParam("企业信息编码")
    private String businessName;

    @ApiModelProperty("结束时间")
    @ApiParam("企业信息编码")
    private Date endtime;
}
