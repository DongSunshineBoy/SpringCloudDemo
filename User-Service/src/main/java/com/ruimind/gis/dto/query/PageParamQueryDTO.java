package com.ruimind.gis.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页对象")
public class PageParamQueryDTO {


    @ApiModelProperty("起始页面默认值为0")
    @ApiParam(defaultValue = "0", example = "0开始页面", name = "起始页面默认值为0")
    private Integer page = 0;

    @ApiParam(defaultValue = "20", example = "20页面大小", name = "页面大小默认值20")
    @ApiModelProperty("页面大小默认值20")
    private Integer size = 20;

    @ApiModelProperty("页面排序字段, 例如:id")
    @ApiParam(example = "businessId 按照企业ID进行排序", name = "页面排序字段, 例如:id")
    private String sortProperties;

    @ApiModelProperty("页面排序升序,降序, 默认:ASC")
    @ApiParam(example = "ASC 进行升序排列", name = "页面排序升序,降序, 默认:ASC")
    private Sort.Direction direction = Sort.Direction.ASC;
}
