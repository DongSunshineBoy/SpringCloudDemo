package com.ruimind.gis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruimind.gis.dto.TbLogCodeDTO;
import com.ruimind.gis.dto.query.TbLogCodeQueryDTO;
import com.ruimind.gis.entity.TbLogCode;
import org.springframework.data.domain.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbLogCodeService extends IService<TbLogCode> {


    /**
     * 插入日志信息
     * @param tbLogCode
     * @return
     */
    boolean insertLog(TbLogCodeDTO tbLogCode);

    /**
     * 根据具体字段进行匹配查询, and 条件
     * @param tbLogCodeQueryDTO
     * @return
     */
    Page<TbLogCodeDTO> finLogByPageQuerySpecifyField(TbLogCodeQueryDTO tbLogCodeQueryDTO);

}
