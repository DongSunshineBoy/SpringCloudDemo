package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbBusinessCode;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbBusinessCodeRepository extends PagingAndSortingRepository<TbBusinessCode, Long> {

    /**
     * 根据企业ID查询对应的企业信息
     * @param businessId
     * @return
     */
    Optional<TbBusinessCode> findByBusinessId(Long businessId);

}
