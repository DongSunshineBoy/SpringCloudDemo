package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruimind.gis.configuration.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
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
public class TbBusinessCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 企业编号
     */
    @TableId(value = "business_id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("企业编号ID")
    @Column(name = "business_id")
    @Id
    private Long businessId;


    //租户信息,单向关联
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbAccountCode> tbAccountCodeList;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbProjectCode> projectCodeList;

    /**
     * 企业名称
     */
    @Comment("企业名称")
    @Column(length = 100, name = "business_name")
    private String businessName;

    /**
     * 企业英文简称
     */
    @Comment("企业英文简称")
    @Column(length = 100, name = "business_name_abbr")
    private String businessNameAbbr;

    /**
     * 企业性质
     */
    @Comment("企业编号ID")
    private Integer businessType;

    /**
     * 企业地址
     */
    @Comment("企业地址")
    private String businessArea;

    /**
     * 企业联系人
     */
    @Comment("企业联系人")
    private String businessContactsName;

    /**
     * 联系方式
     */
    @Comment("联系方式")
    private String businessContactsTel;

    /**
     * 是否可用
     */
    @Comment("是否可用")
    private Byte businessDeleted = 1;
}
