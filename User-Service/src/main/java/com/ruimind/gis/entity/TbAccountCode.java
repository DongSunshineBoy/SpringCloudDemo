package com.ruimind.gis.entity;

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
public class TbAccountCode implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("租户id")
    private Long accountId;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "business_id")
    private TbBusinessCode tbBusinessCode;


    /**
     * 项目编号
     */
    @Comment("项目编号")
    private Long projectId;

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
