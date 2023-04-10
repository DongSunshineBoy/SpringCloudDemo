package com.ruimind.gis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruimind.gis.dto.TbProjectCodeDTO;
import com.ruimind.gis.dto.query.TbProjectCodeQueryDTO;
import com.ruimind.gis.entity.TbProjectCode;
import org.springframework.data.domain.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
public interface TbProjectCodeService extends IService<TbProjectCode> {

    /**
     * 插入项目信息
     * @param projectCodeDTO
     * @return
     */
    boolean insertProject(TbProjectCodeDTO projectCodeDTO);


    /**
     * 修改项目信息
     * @param projectCodeDTO
     * @return
     */
    public boolean updateProject(TbProjectCodeDTO projectCodeDTO);


    /**
     * 根据项目ID删除项目信息
     * @param pid
     * @return
     */
    boolean deleteProjectByPid(Long pid);



    /**
     * 根据具体字段查询对应的项目信息
     * @param projectCodeDTO
     * @return
     */
    Page<TbProjectCodeDTO> findProjectByPageQuerySpecifyField(TbProjectCodeQueryDTO projectCodeDTO);


    /**
     * 根据企业ID,查询项目名称
     * @param pid
     * @return
     */
    String getProjectNameById(Long pid);

}
