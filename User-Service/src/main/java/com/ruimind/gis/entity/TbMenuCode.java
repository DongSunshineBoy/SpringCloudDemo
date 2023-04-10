package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruimind.gis.configuration.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
@Entity
public class TbMenuCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单编号
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("租户地图表编码id")
    @Column(name = "menu_id")
    private Long menuId;


    //租户权限,单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbAccountPermissionCode> tbAccountPermissionCode;

    /**
     * 菜单名称
     */
    @Comment("菜单名称")
    private String menuName;

    /**
     * 菜单编码
     */
    @Comment("菜单编码")
    private String menuCode;

    /**
     * 父节点编号
     */
    @Comment("父节点编号")
    private Long parentMenuId;

    /**
     * 节点类型 0菜单 1按钮  2工具栏
     */
    @Comment("节点类型 0菜单 1按钮  2工具栏")
    private Integer menuType;

    /**
     * 图标地址url
     */
    @Comment("图标地址url")
    private String iconUrl;

    /**
     * 顺序号
     */
    @Comment("顺序号")
    private Integer index;

    /**
     * 页面对应的地址
     */
    @Comment("页面对应的地址")
    private String menuAddress;

    /**
     * 层次
     */
    @Comment("层次")
    private Integer level;

    /**
     * 菜单编号的路径
     */
    @Comment("菜单编号的路径")
    private String menuAllPath;

    /**
     * 是否可用
     */
    @Comment("是否可用")
    private Integer menuDeleted = 1;

    /**
     * 创建时间
     */
    @Comment("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建用户编号
     */
    @Comment("创建用户编号")
    private Long createUserid;

    /**
     * 菜单子集结点, 默认不创建改属性
     */
    @Transient
    private List<TbMenuCode> children;

}
