package com.ruimind.gis.dto.query;

import com.ruimind.gis.configuration.Comment;
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
@ApiModel("项目分页实体")
public class TbProjectCodeQueryDTO extends PageParamQueryDTO {

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
    @Length(min = 0, max = 100, message = "项目名称在0~100之间")
    private String projectName;

    /**
     * 项目负责人
     */
    @ApiModelProperty("项目leader名称")
    @Length(min = 0, max = 30, message = "项目leader名称在0~30之间")
    private String projectLeaderName;

    /**
     * 负责人联系方式
     */
    @Comment("负责人联系方式")
    @Length(min = 0, max = 11, message = "负责人联系方式在0~11之间")
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
