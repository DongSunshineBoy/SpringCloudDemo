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
public class TbUserAccountRoleHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("租户角色id")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 租户编号
     */
    @Comment("租户编号")
    @Column(name = "account_id")
    private Long accountId;


    /**
     * 开始时间
     */
    @Comment("开始时间")
    private Date starttime;

    /**
     * 角色编号
     */
    @Comment("角色编号")
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 结束时间
     */
    @Comment("结束时间")
    private Date endtime;

    /**
     * 用户角色租户编号
     */
    @Comment("用户角色租户编号")
    @Column(name = "user_account_role_id")
    private Long userAccountRoleId;


}
