package com.orderservice.orderservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.orderservice.orderservice.configuration.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class UserOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户订单id
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    @Comment("用户ID")
    private Integer id;

    /**
     * 用户订单数量
     */
    @Comment("订单数量")
    @Column(insertable = true, updatable = true, length = 30)
    private Integer orderNum;

    /**
     * 用户订单名称
     */
    @Comment("订单名称")
    @Column(insertable = true, updatable = true, length = 30)
    private String oderName;

}
