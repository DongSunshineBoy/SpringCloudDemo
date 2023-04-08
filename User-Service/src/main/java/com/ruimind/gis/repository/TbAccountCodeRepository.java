package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbAccountCode;
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
public interface TbAccountCodeRepository extends PagingAndSortingRepository<TbAccountCode, Long> {

    /**
     * 根据租户ID查询租户信息
     * @param accountId
     * @return
     */
    Optional<TbAccountCode> findByAccountId(Long accountId);

    /**
     * 根据租户ID删除租户信息
     * @param accountId
     */
    void deleteByAccountId(Long accountId);
}
