package com.ruimind.gis.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("企业查询信息实体")
public class TbBusinessQueryDTO extends PageParamQueryDTO{

    /**
     * 企业编号
     * 更新时候需要id，否则不需要
     */

    @ApiModelProperty(value = "企业编号ID")
    @ApiParam(name = "企业ID")
    private Long businessId;

    /**
     * 企业名称
     */
    @Length(min = 0, max = 100, message = "企业名称长度必须在0~100之间")
    @ApiModelProperty("企业名称")
    @ApiParam(name = "名称", example = "西安睿智科技")
    private String businessName;

    /**
     * 企业英文简称
     */
    @Length(min = 0, max = 100, message = "企业英文名称长度必须在0~100之间")
    @ApiParam(name = "企业英文名称", example = "xianruizhikeji")
    private String businessNameAbbr;

    /**
     * 企业性质
     */
    @ApiModelProperty("企业性质")
    @ApiParam(name = "企业性质", example = "0 国有企业 1 私有企业")
    private Integer businessType;

    /**
     * 企业地址
     */
    @Length(min = 0, max = 200, message = "企业地址长度在0～200之间")
    @ApiModelProperty("企业地址")
    @ApiParam(name = "企业地址", example = "西安市区")
    private String businessArea;

    /**
     * 企业联系人
     */
    @Length(min = 0, max = 50, message = "企业联系人名称必须在0~50之间")
    @ApiModelProperty("企业联系人")
    @ApiParam(name = "企业联系人", example = "董文涛")
    private String businessContactsName;

    /**
     * 联系方式
     */
    @Length(min = 0, max = 50, message = "企业联系人方式必须在0~50之间")
    @ApiModelProperty("联系方式")
    @ApiParam(name = "联系方式", example = "109092312312")
    private String businessContactsTel;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用")
    @ApiParam(name = "是否可用", example = "0")
    private Integer businessDeleted;

}
