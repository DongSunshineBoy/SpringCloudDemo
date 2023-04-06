package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruimind.gis.configuration.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long roleId;

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
