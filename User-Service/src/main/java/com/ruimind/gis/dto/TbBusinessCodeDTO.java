package com.ruimind.gis.dto;

import com.ruimind.gis.configuration.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel("企业信息实体类")
public class TbBusinessCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 企业编号
     */

    @ApiModelProperty("企业编号ID")
    private Long businessId;

    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String businessName;

    /**
     * 企业英文简称
     */
    @Comment("企业英文简称")
    private String businessNameAbbr;

    /**
     * 企业性质
     */
    @ApiModelProperty("企业编号ID")
    private Integer businessType;

    /**
     * 企业地址
     */
    @ApiModelProperty("企业地址")
    private String businessArea;

    /**
     * 企业联系人
     */
    @ApiModelProperty("企业联系人")
    private String businessContactsName;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String businessContactsTel;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用")
    private Integer businessDeleted;


}
