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
public class TbBusinessNameHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("企业信息编码")
    @TableId(value = "business_name_history_id", type = IdType.AUTO)
    private Long businessNameHistoryId;

    @Comment("企业编号")
    @Column(name = "business_id")
    private Long businessId;

    @Comment("开始时间")
    private Date starttime;

    @Comment("企业名称")
    private String businessName;

    @Comment("结束时间")
    private Date endtime;

    @Comment("是否删除")
    private Byte isDeleted = 1;
}
