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
public class TbAccountMapinfoCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("租户地图信息ID")
    @TableId(value = "account_mapinfo_id", type = IdType.AUTO)
    private Long accountMapinfoId;


    /**
     * 租户编号
     */
    @Comment("租户编号")
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 菜单编号
     */
    @Comment("菜单编号")
    @Column(name = "mapinfo_id")
    private Long mapinfoId;

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
    private Date createTime;

    /**
     * 创建用户编号
     */
    @Comment("创建用户编号")
    private Long createUserid;

}
