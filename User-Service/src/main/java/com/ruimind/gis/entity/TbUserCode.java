package com.ruimind.gis.entity;

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

    //用户租户角色历史信息，单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbUserNameHistory> tbUserNameHistories;

    //用户登陆历史, 单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbLoginNameHistory> tbLoginNameHistories;

    //用户登陆密码历史, 单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbLoginPasswordHistory> tbLoginPasswordHistories;

    //用户删除信息历史, 单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbUserDeletedHistory> tbUserDeletedHistories;

    //用户租户角色信息历史, 单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbUserAccountRoleHistory> tbUserAccountRoleHistories;

    //用户租户角色信息, 单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbUserAccountRoleCode> tbUserAccountRoleCodes;

    //用户租户设备信息，单向关联
//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private List<TbDeviceCode> tbDeviceCodes;

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
