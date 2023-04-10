package com.ruimind.gis.repository;

import com.ruimind.gis.entity.TbProjectCode;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
public interface TbProjectCodeRepository extends PagingAndSortingRepository<TbProjectCode, Long>,
        JpaSpecificationExecutor<TbProjectCode> {

    /**
     * 根据项目ID，查询对应的项目信息
     * @param pid
     * @return
     */
    Optional<TbProjectCode> findByProjectId(Long pid);

}
