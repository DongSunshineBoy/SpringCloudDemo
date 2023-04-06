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
public class TbLoginNameHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("用户登陆历史id")
    @TableId(value = "login_name_history_id", type = IdType.AUTO)
    private Long loginNameHistoryId;

    /**
     * 用户编号
     */
    @Comment("用户编号")
    private Long userId;

    /**
     * 开始时间
     */
    @Comment("开始时间")
    private Date starttime;

    /**
     * 登录名
     */
    @Comment("登录名")
    private String loginName;

    /**
     * 结束时间
     */
    @Comment("结束时间")
    private Date endtime;

}
