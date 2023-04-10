package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbMenuCode;
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
public interface TbMenuCodeRepository extends PagingAndSortingRepository<TbMenuCode, Long> {

    Optional<TbMenuCode> findByMenuId(Long mid);

}
