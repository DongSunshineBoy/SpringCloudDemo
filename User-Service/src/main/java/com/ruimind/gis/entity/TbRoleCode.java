package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class TbRoleCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("角色id")
    @Column(name = "role_id")
    private Long roleId;


    //权限信息， 单向关联
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbAccountPermissionCode> tbAccountPermissionCodes;


    //租户信息,单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbAccountMapinfoCode> tbAccountMapinfoCode;


    //用户租户角色信息，单向关联
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbUserAccountRoleCode> tbUserAccountRoleCodes;


    //用户租户角色历史信息，单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbUserAccountRoleHistory> tbUserAccountRoleHistories;

    /**
     * 角色名称
     */
    @Comment("角色名称")
    private String roleName;

    /**
     * 角色缩写
     */
    @Comment("角色缩写")
    private String roleNameAbbr;

    /**
     * 角色类型
     */
    @Comment("角色类型")
    private Integer roleType;

    /**
     * 项目编号
     */
    @Comment("项目编号")
    @Column(name = "project_id")
    private Long projectId;

    /**
     * 创建时间
     */
    @Comment("创建时间")
    private Date roleCreateTime;

    /**
     * 创建用户编号
     */
    @Comment("创建用户编号")
    private Long roleCreateUserid;


}
