package com.ruimind.gis.dto;

import com.ruimind.gis.configuration.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

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


    @ApiModelProperty(name = "企业所属租户")
    private List<TbAccountCodeDTO> tbAccountCodeList;


    @ApiModelProperty(name = "企业所属项目")
    private List<TbProjectCodeDTO> projectCodeList;

    /**
     * 企业编号
     * 更新时候需要id，否则不需要
     */

    @ApiModelProperty(value = "企业编号ID", hidden = true)
    private Long businessId;

    /**
     * 企业名称
     */
    @Length(min = 0, max = 100, message = "企业名称长度必须在0~100之间")
    @ApiModelProperty("企业名称")
    private String businessName;

    /**
     * 企业英文简称
     */
    @Length(min = 0, max = 100, message = "企业英文名称长度必须在0~100之间")
    @Comment("企业英文简称")
    private String businessNameAbbr;

    /**
     * 企业性质
     */
    @ApiModelProperty("企业性质")
    private Integer businessType;

    /**
     * 企业地址
     */
    @Length(min = 0, max = 200, message = "企业地址长度在0～200之间")
    @ApiModelProperty("企业地址")
    private String businessArea;

    /**
     * 企业联系人
     */
    @Length(min = 0, max = 50, message = "企业联系人名称必须在0~50之间")
    @ApiModelProperty("企业联系人")
    private String businessContactsName;

    /**
     * 联系方式
     */
    @Length(min = 0, max = 50, message = "企业联系人方式必须在0~50之间")
    @ApiModelProperty("联系方式")
    private String businessContactsTel;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用")
    private Byte businessDeleted = 1;
}
