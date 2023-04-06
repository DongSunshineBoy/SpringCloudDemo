package com.ruimind.gis.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel("登陆密码历史")
public class TbLoginPasswordHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("登陆密码编号")
    private Long loginPasswordHistoryId;

    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private Long userId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date starttime;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String loginPassword;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endtime;


}
