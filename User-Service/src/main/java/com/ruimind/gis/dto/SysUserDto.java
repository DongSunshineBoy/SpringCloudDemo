package com.ruimind.gis.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel("用户dto")
public class SysUserDto implements Serializable, Comparable<SysUserDto> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer id;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @Override
    public int compareTo(SysUserDto o) {
        return 0;
    }

}
