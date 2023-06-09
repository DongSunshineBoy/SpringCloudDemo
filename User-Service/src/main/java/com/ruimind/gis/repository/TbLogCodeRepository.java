package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbLogCode;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbLogCodeRepository extends PagingAndSortingRepository<TbLogCode, Long> , JpaSpecificationExecutor<TbLogCode> {

}
