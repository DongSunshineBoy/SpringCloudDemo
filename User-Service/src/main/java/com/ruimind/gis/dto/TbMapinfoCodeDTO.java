package com.ruimind.gis.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel("地图信息")
public class TbMapinfoCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("租户地图表编码id")
    private Integer mapinfoId;

    /**
     * 地图名称
     */
    @ApiModelProperty("地图名称")
    private String mapName;

    /**
     * 地图路径
     */
    @ApiModelProperty("地图路径")
    private String mapPath;

    /**
     * 调用地址
     */
    @ApiModelProperty("调用地址")
    private String mapApiUrl;

    /**
     * 地图类型 0 在线  1离线
     */
    @ApiModelProperty("地图类型 0 在线  1离线")
    private Integer mapType;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 操作用户编号
     */
    @ApiModelProperty("操作用户编号")
    private Long createUserid;


}
