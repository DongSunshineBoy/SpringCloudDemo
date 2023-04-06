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
public class TbProjectCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    @TableId(value = "project_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("项目编码id")
    private Long projectId;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "business_id")
    private TbBusinessCode tbBusinessCode;

    /**
     * 企业编号
     */
    @Comment("企业编号")
    private Long businessId;

    /**
     * 项目名称
     */
    @Comment("项目名称")
    private String projectName;

    /**
     * 项目负责人
     */
    @Comment("项目编码id")
    private String projectLeaderName;

    /**
     * 负责人联系方式
     */
    @Comment("负责人联系方式")
    private String projectLeaderTel;

    /**
     * 项目开始日期
     */
    @Comment("项目开始日期")
    private Date projectStartdate;

    /**
     * 项目结束日期
     */
    @Comment("项目结束日期")
    private Date projectEnddate;

    /**
     * 创建时间
     */
    @Comment("创建时间")
    private Date projectCreateTime;

    /**
     * 创建用户编号
     */
    @Comment("创建用户编号")
    private Long projectCreateUserid;


}
