package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class TbResourceCallCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "resource_call_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("资源id")
    private Long resourceCallId;

    /**
     * 名称
     */
    @Comment("名称")
    private String callName;

    /**
     * 地址
     */
    @Comment("地址")
    private String url;

    /**
     * 操作时间
     */
    @Comment("操作时间")
    private Date createDatetime;

    /**
     * 用户编号
     */
    @Comment("用户编号")
    private Long userId;

    /**
     * 项目编号
     */
    @Comment("项目编号")
    private Long projectId;


}
