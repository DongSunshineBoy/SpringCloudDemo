package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbBusinessNameHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbBusinessNameHistoryRepository extends PagingAndSortingRepository<TbBusinessNameHistory, Long> {

    List<TbBusinessNameHistory> findByBusinessId(Long businessId);


    Page<TbBusinessNameHistory> findHistoryBusinessNameByBusinessId(Long businessIdm, Pageable pageable);

}
