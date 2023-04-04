package com.orderservice.orderservice.mapper;

import com.orderservice.orderservice.entity.UserOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@Mapper
public interface UserOrderMapper extends BaseMapper<UserOrder> {

}
