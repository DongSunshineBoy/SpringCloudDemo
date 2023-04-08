package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbBusinessNameHistory;
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
public interface TbBusinessNameHistoryRepository extends PagingAndSortingRepository<TbBusinessNameHistory, Long> {

    Optional<TbBusinessNameHistory> findByBusinessId(Long businessId);

}
