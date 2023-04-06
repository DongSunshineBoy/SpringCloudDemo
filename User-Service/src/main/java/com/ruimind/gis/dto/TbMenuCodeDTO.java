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
@ApiModel("菜单实体dto")
public class TbMenuCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单编号
     */
    @ApiModelProperty("租户地图表编码id")
    private Long menuId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /**
     * 菜单编码
     */
    @ApiModelProperty("菜单编码")
    private String menuCode;

    /**
     * 父节点编号
     */
    @ApiModelProperty("父节点编号")
    private Long parentMenuId;

    /**
     * 节点类型 0菜单 1按钮  2工具栏
     */
    @ApiModelProperty("节点类型 0菜单 1按钮  2工具栏")
    private Integer menuType;

    /**
     * 图标地址url
     */
    @ApiModelProperty("图标地址url")
    private String iconUrl;

    /**
     * 顺序号
     */
    @ApiModelProperty("顺序号")
    private Integer index;

    /**
     * 页面对应的地址
     */
    @ApiModelProperty("页面对应的地址")
    private String menuAddress;

    /**
     * 层次
     */
    @ApiModelProperty("层次")
    private Integer level;

    /**
     * 菜单编号的路径
     */
    @ApiModelProperty("菜单编号的路径")
    private String menuAllPath;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用")
    private Integer menuDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 创建用户编号
     */
    @ApiModelProperty("创建用户编号")
    private Long createUserid;


}
