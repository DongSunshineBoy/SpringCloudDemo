package com.ruimind.gis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruimind.gis.dto.TbMenuCodeDTO;
import com.ruimind.gis.entity.TbMenuCode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbMenuCodeService extends IService<TbMenuCode> {

    /**
     *  增加菜单信息
     * @param tbMenuCodeDTO
     * @return
     */
    boolean insertMenu(TbMenuCodeDTO tbMenuCodeDTO);


    /**
     *  修改菜单信息
     * @param tbMenuCodeDTO
     * @return
     */
    boolean updateMenu(TbMenuCodeDTO tbMenuCodeDTO);


    /**
     * 根据企业ID，删除菜单信息， 修改逻辑的是否删除字段值
     * @param mid
     * @return
     */
    boolean deleteMenuById(Long mid);



    /**
     * 根据企业ID，删除菜单信息， 修改逻辑的是否删除字段值
     * @param mid
     * @return
     */
    List<TbMenuCodeDTO> findMenuTreeByParentId(Long mid);

    /**
     * 获取所有菜单的树形结构
     * @return
     */

    public List<TbMenuCodeDTO> findMenuTree();

}
