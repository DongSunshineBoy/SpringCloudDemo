package com.ruimind.gis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruimind.gis.dto.SysUserDto;
import com.ruimind.gis.entity.SysUser;
import com.ruimind.gis.mapper.SysUserMapper;
import com.ruimind.gis.repository.SysUserRepository;
import com.ruimind.gis.service.SysUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private SysUserRepository sysUserRepository;

    private SysUserMapper sysUserMapper;

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public SysUserServiceImpl(SysUserRepository sysUserRepository, SysUserMapper sysUserMapper) {
        this.sysUserRepository = sysUserRepository;
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public void insert(SysUserDto user) {
        SysUser sysUser = mapper.map(user, SysUser.class);
        sysUserRepository.saveAndFlush(sysUser);
    }

    @Override
    public SysUserDto getUserById(Integer id) {
        SysUser sysUser = sysUserRepository.findById(id).orElseGet(SysUser::new);
        return mapper.map(sysUser, SysUserDto.class);
    }
}
