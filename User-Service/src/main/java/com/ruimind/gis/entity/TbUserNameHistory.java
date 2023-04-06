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
public class TbUserNameHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_name_history_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("用户名称修改历史id")
    private Long userNameHistoryId;

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
     * 用户姓名
     */
    @Comment("用户姓名")
    private String userName;

    /**
     * 结束时间
     */
    @Comment("结束时间")
    private Date endtime;


}
