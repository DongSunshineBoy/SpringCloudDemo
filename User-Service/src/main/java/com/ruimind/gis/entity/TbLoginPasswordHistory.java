package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruimind.gis.configuration.Comment;
import io.swagger.annotations.ApiModelProperty;
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
public class TbLoginPasswordHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "login_password_history_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("登陆密码编号")
    private Long loginPasswordHistoryId;

    /**
     * 用户编号
     */
    @Comment("用户编号")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date starttime;

    /**
     * 登录密码
     */
    @Comment("登录密码")
    private String loginPassword;

    /**
     * 结束时间
     */
    @Comment("结束时间")
    private Date endtime;


}
