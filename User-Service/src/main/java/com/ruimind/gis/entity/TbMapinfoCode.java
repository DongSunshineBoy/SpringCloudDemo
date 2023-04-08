package com.ruimind.gis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruimind.gis.configuration.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class TbMapinfoCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "mapinfo_id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("租户地图表编码id")
    @Column(name = "mapinfo_id")
    private Integer mapinfoId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "mapinfo_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<TbAccountMapinfoCode> tbAccountMapinfoCodes;

    /**
     * 地图名称
     */
    @Comment("地图名称")
    private String mapName;

    /**
     * 地图路径
     */
    @Comment("地图路径")
    private String mapPath;

    /**
     * 调用地址
     */
    @Comment("调用地址")
    private String mapApiUrl;

    /**
     * 地图类型 0 在线  1离线
     */
    @Comment("地图类型 0 在线  1离线")
    private Integer mapType;

    /**
     * 创建时间
     */
    @Comment("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 操作用户编号
     */
    @Comment("操作用户编号")
    private Long createUserid;


}
