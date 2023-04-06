package com.ruimind.gis.dto;

import com.ruimind.gis.configuration.Comment;
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
@ApiModel("项目实体dto")
public class TbProjectCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编码id")
    private Long projectId;

    /**
     * 企业编号
     */
    @ApiModelProperty("企业编号")
    private Long businessId;

    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    private String projectName;

    /**
     * 项目负责人
     */
    @ApiModelProperty("项目编码id")
    private String projectLeaderName;

    /**
     * 负责人联系方式
     */
    @Comment("负责人联系方式")
    private String projectLeaderTel;

    /**
     * 项目开始日期
     */
    @ApiModelProperty("项目开始日期")
    private Date projectStartdate;

    /**
     * 项目结束日期
     */
    @ApiModelProperty("项目结束日期")
    private Date projectEnddate;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date projectCreateTime;

    /**
     * 创建用户编号
     */
    @ApiModelProperty("创建用户编号")
    private Long projectCreateUserid;


}
