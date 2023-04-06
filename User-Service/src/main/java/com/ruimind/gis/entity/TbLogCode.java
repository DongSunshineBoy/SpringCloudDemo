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
public class TbLogCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("日志编号")
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    /**
     * 操作ip
     */
    @Comment("操作ip")
    private String logIp;

    /**
     * 操作内容
     */
    @Comment("操作内容")
    private String logContext;

    /**
     * 操作时间
     */
    @Comment("操作时间")
    private Date logDatetime;

    /**
     * 操作状态
     */
    @Comment("操作状态")
    private String loginStatus;

    /**
     * 日志类型
     */
    @Comment("日志类型")
    private Integer logType;

    /**
     * 操作用户编号
     */
    @Comment("操作用户编号")
    private Long logOperateUserid;


}
