package com.ruimind.gis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruimind.gis.advice.GlobalResponseResultEnum;
import com.ruimind.gis.advice.GlobalRunTimeException;
import com.ruimind.gis.dto.TbMenuCodeDTO;
import com.ruimind.gis.entity.TbMenuCode;
import com.ruimind.gis.mapper.TbMenuCodeMapper;
import com.ruimind.gis.repository.TbMenuCodeRepository;
import com.ruimind.gis.service.TbMenuCodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@Service
public class TbMenuCodeServiceImpl extends ServiceImpl<TbMenuCodeMapper, TbMenuCode> implements TbMenuCodeService {

    private final TbMenuCodeMapper tbMenuCodeMapper;

    private final TbMenuCodeRepository tbMenuCodeRepository;

    private static List<TbMenuCode> cacheMenuList = new CopyOnWriteArrayList<>();

    private final static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TbMenuCodeServiceImpl(TbMenuCodeMapper tbMenuCodeMapper, TbMenuCodeRepository tbMenuCodeRepository) {
        this.tbMenuCodeMapper = tbMenuCodeMapper;
        this.tbMenuCodeRepository = tbMenuCodeRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertMenu(TbMenuCodeDTO tbMenuCodeDTO) {
        TbMenuCode tbMenuCode = modelMapper.map(tbMenuCodeDTO, TbMenuCode.class);
        return tbMenuCodeRepository.save(tbMenuCode).getMenuId() != null;
    }

    @Override
    public boolean updateMenu(TbMenuCodeDTO tbMenuCodeDTO) {
        Long menuId = tbMenuCodeDTO.getMenuId();

        if (menuId == null)
            throw new GlobalRunTimeException(GlobalResponseResultEnum.UNKNOW_HOST_USER_LOGIN_EXCEPTION.getMessage(),
                GlobalResponseResultEnum.USER_LOGIN_SUCCESS_EXCEPTION.getCode());

        TbMenuCode tbMenuCode = modelMapper.map(tbMenuCodeDTO, TbMenuCode.class);
        return tbMenuCodeRepository.save(tbMenuCode).getMenuId().equals(menuId);
    }

    @Override
    public List<TbMenuCodeDTO> findMenuTreeByParentId(Long mid) {
        return null;
    }


    @Override
    public List<TbMenuCodeDTO> findMenuTree() {

        //获取所有菜单加载内存缓存
        cacheMenuList = (List<TbMenuCode>) tbMenuCodeRepository.findAll();

        List<TbMenuCode> tbMenuCodes = new LinkedList<>();

        //获取定级菜单集合
        cacheMenuList.forEach((menuCode)->{
            if (menuCode.getParentMenuId() == 0) {
                tbMenuCodes.add(menuCode);
            }
        });

        List<TbMenuCode> parentNodeMenu = new LinkedList<>();

        for (TbMenuCode tbMenuCode : tbMenuCodes) {
            TbMenuCode menuCode = buildTree(tbMenuCode, cacheMenuList, cacheMenuList.size());
            parentNodeMenu.add(menuCode);
        }

        List<TbMenuCodeDTO> tbMenuCodeList = modelMapper.map(parentNodeMenu, List.class);
        return tbMenuCodeList;
    }

    @Override
    public boolean deleteMenuById(Long mid) {

        Optional<TbMenuCode> menuCode = tbMenuCodeRepository.findByMenuId(mid);

        AtomicBoolean isDeleted = new AtomicBoolean(false);

        menuCode.ifPresent(tbMenuCode -> {
            tbMenuCode.setMenuDeleted(0);
            isDeleted.set(tbMenuCodeRepository.save(tbMenuCode).getMenuId().equals(mid));
        });

        return isDeleted.get();
    }

    private static TbMenuCode buildTree(TbMenuCode tbMenuCode, Iterable<TbMenuCode> nodeDemoList, int size) {

        List<TbMenuCode> children = new ArrayList<>();

        if (tbMenuCode == null) return null;

        if (size < 0) return tbMenuCode;

        for (TbMenuCode nodeDemo : nodeDemoList) {

            if (nodeDemo.getMenuId() == 0) {
                continue;
            }
            if (nodeDemo.getParentMenuId().equals(tbMenuCode.getMenuId())) {
                children.add(buildTree(nodeDemo, nodeDemoList, --size));
            }
        }

        tbMenuCode.setChildren(children);
        return tbMenuCode;
    }


}
