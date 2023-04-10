package com.ruimind.gis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruimind.gis.dto.TbBusinessCodeDTO;
import com.ruimind.gis.dto.query.PageParamQueryDTO;
import com.ruimind.gis.dto.query.TbBusinessQueryDTO;
import com.ruimind.gis.entity.TbBusinessCode;
import org.springframework.data.domain.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbBusinessCodeService extends IService<TbBusinessCode> {

    /**
     *  增加企业信息
     * @param tbBusinessCodeDTO
     * @return
     */
    boolean insertBusiness(TbBusinessCodeDTO tbBusinessCodeDTO);


    /**
     *  修改企业信息
     * @param tbBusinessCodeDTO
     * @return
     */
    boolean updateBusiness(TbBusinessCodeDTO tbBusinessCodeDTO);

    /**
     *  查询所有企业信息
     * @return
     */
    Page<TbBusinessCodeDTO> findAllBusinessByPage(PageParamQueryDTO pageRequest);

    /**
     *  根据具体字段查询对应的企业信息
     * @return
     */
    Page<TbBusinessCodeDTO> findBusinessByPageQuerySpecifyField(TbBusinessQueryDTO pageRequest);


    /**
     * 根据企业ID，删除企业信息， 修改逻辑的是否删除字段值
     * @param bid
     * @return
     */
    boolean deleteBusinessById(Long bid);

    /**
     * 根据企业ID,查询企业名称
     * @param bid
     * @return
     */
    String getBusinessNameById(Long bid);

}
