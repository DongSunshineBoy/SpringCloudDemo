package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class TbUserCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("角色id")
    private Long userId;

    /**
     * 用户姓名
     */
    @Comment("用户姓名")
    private String userName;

    /**
     * 登录名
     */
    @Comment("登录名")
    private String loginName;

    /**
     * 用户姓名缩写
     */
    @Comment("用户姓名缩写")
    private String userNameAbbr;

    /**
     * 密码
     */
    @Comment("密码")
    private String loginPassword;

    /**
     * 联系方式
     */
    @Comment("联系方式")
    private String userTel;

    /**
     * 是否可用
     */
    @Comment("是否可用")
    private Integer userDeleted;

    /**
     * 创建时间
     */
    @Comment("创建时间")
    private Date userCreateTime;

    /**
     * 创建人用户编号
     */
    @Comment("创建人用户编号")
    private Long userCreateUserid;

    /**
     * 上次登录时间
     */
    @Comment("上次登录时间")
    @TableField("Last_login_time")
    private Date lastLoginTime;

    /**
     * 组织机构编号
     */
    @Comment("组织机构编号")
    private Integer organizationTreeId;

    /**
     * 组织结构编码
     */
    @Comment("组织结构编码")
    private String organizationTreeCode;


}
