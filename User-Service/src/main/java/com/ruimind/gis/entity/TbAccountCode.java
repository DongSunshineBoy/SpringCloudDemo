package com.ruimind.gis.entity;

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
public class TbAccountCode implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("租户id")
    @Column(name = "account_id")
    private Long accountId;


    //租户权限,单向关联
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private List<TbAccountPermissionCode> tbAccountPermissionCode;



    //租户地图信息,单向关联
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private List<TbAccountMapinfoCode> tbAccountMapinfoCodes;

    //用户历史角色信息,单向关联
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private List<TbUserAccountRoleHistory> tbUserAccountRoleHistories;


    //租户用户角色, 单向关联
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private List<TbUserAccountRoleCode> tbUserAccountRoleCode;


    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private TbProjectCode tbProjectCode;

    /**
     * 项目编号
     */
    @Comment("项目编号")
    @Column(name = "project_id")
    private Long projectId;

    /**
     * 项目编号
     */
    @Comment("项目编号")
    @Column(name = "is_deleted")
    private Boolean isDeleted;


    /**
     * 企业编号
     */
    @Comment("企业编号")
    @Column(name = "business_id")
    private Long businessId;

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
