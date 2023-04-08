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
 * @since 2023-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class TbUserAccountRoleCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_account_role_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("角色id")
    @Column(name = "user_account_role_id")
    private Long userAccountRoleId;


    //用户租户角色信息历史, 单向关联
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_account_role_id")
    private List<TbUserAccountRoleHistory> tbUserAccountRoleHistories;

    /**
     * 用户编号
     */
    @Comment("用户编号")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 租户编号
     */
    @Comment("租户编号")
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 角色编号
     */
    @Comment("角色编号")
    @Column(name = "role_id")
    private Long roleId;

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


}
