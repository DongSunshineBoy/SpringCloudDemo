package com.user.dwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.user.dwt.configuration.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    @Comment("用户id")
    private Integer id;

    /**
     * 用户名称
     */
    @Column(insertable = true, updatable = true, nullable = true, length = 20)
    @Comment("用户名称")
    private String name;

    @Comment("用户年龄")
    @Column(insertable = true, updatable = true, nullable = true, length = 2)
    private Integer age;
}
