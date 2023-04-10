package com.ruimind.gis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruimind.gis.dto.TbBusinessNameHistoryDTO;
import com.ruimind.gis.entity.TbBusinessNameHistory;
import org.springframework.data.domain.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbBusinessNameHistoryService extends IService<TbBusinessNameHistory> {

    /**
     * 通过企业编号查询企业历史
     * @param businessId
     * @return
     */
    Page<TbBusinessNameHistoryDTO> findBusinessHistoryNameByBId(Long businessId);

    /**
     * 根据企业id，删除企业信息,逻辑删除修改其是否删除字段
     * @param bid
     */
    boolean deleteBusinessHistoryNameById(Long bid);

}
