package com.user.dwt.service;

import com.user.dwt.dto.SysUserDto;
import com.user.dwt.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
public interface SysUserService extends IService<SysUser> {

    void insert(SysUserDto user);

    SysUserDto getUserById(Integer id);
}
