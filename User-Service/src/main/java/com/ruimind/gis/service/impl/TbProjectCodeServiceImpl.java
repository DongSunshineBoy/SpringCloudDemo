package com.ruimind.gis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruimind.gis.advice.GlobalResponseResultEnum;
import com.ruimind.gis.advice.GlobalRunTimeException;
import com.ruimind.gis.dto.TbProjectCodeDTO;
import com.ruimind.gis.dto.query.TbProjectCodeQueryDTO;
import com.ruimind.gis.entity.TbProjectCode;
import com.ruimind.gis.mapper.TbProjectCodeMapper;
import com.ruimind.gis.repository.TbProjectCodeRepository;
import com.ruimind.gis.service.TbProjectCodeService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@Service
public class TbProjectCodeServiceImpl extends ServiceImpl<TbProjectCodeMapper, TbProjectCode> implements TbProjectCodeService {


    private final TbProjectCodeMapper tbProjectCodeMapper;

    private final TbProjectCodeRepository tbProjectCodeRepository;


    private final static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TbProjectCodeServiceImpl(TbProjectCodeMapper tbProjectCodeMapper, TbProjectCodeRepository tbProjectCodeRepository) {
        this.tbProjectCodeMapper = tbProjectCodeMapper;
        this.tbProjectCodeRepository = tbProjectCodeRepository;
    }

    @Override
    public boolean insertProject(TbProjectCodeDTO projectCodeDTO) {
        TbProjectCode tbProjectCode = modelMapper.map(projectCodeDTO, TbProjectCode.class);
        return tbProjectCodeRepository.save(tbProjectCode).getProjectId() != null;
    }


    @Override
    public boolean updateProject(TbProjectCodeDTO projectCodeDTO) {
        Long projectId = projectCodeDTO.getProjectId();

        if (projectId == null)
            throw new GlobalRunTimeException(GlobalResponseResultEnum.NOT_NULL_ID_WHEN_UPDATE.getMessage(),
                GlobalResponseResultEnum.NOT_NULL_ID_WHEN_UPDATE.getCode());

        TbProjectCode tbProjectCode = modelMapper.map(projectCodeDTO, TbProjectCode.class);
        return tbProjectCodeRepository.save(tbProjectCode).getProjectId().equals(projectId);
    }

    @Override
    public boolean deleteProjectByPid(Long pid) {

        AtomicBoolean isDeleted = new AtomicBoolean(false);

        tbProjectCodeRepository.findByProjectId(pid)
                .ifPresent(tbProjectCode -> {
            tbProjectCode.setIsDeleted((byte)0);

            isDeleted.set(tbProjectCodeRepository.save(tbProjectCode)
                    .getIsDeleted()
                    .equals((byte)0));
        });

        return isDeleted.get();
    }

    @Override
    public Page<TbProjectCodeDTO> findProjectByPageQuerySpecifyField(TbProjectCodeQueryDTO projectCodeDTO) {

        Date projectEnddate = projectCodeDTO.getProjectEnddate();

        String projectName = projectCodeDTO.getProjectName();

        Long projectId = projectCodeDTO.getProjectId();

        Long projectCreateUserid = projectCodeDTO.getProjectCreateUserid();

        Date projectStartdate = projectCodeDTO.getProjectStartdate();

        String projectLeaderName = projectCodeDTO.getProjectLeaderName();

        Long businessId = projectCodeDTO.getBusinessId();

        Date projectCreateTime = projectCodeDTO.getProjectCreateTime();

        String projectLeaderTel = projectCodeDTO.getProjectLeaderTel();


        Specification<TbProjectCode> example = (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(projectName)) {
                Predicate projectName1 = criteriaBuilder.like(root.get("projectName").as(String.class), projectName);
                predicateList.add(projectName1);
            }

            if (StringUtils.isNotBlank(projectLeaderName)) {
                Predicate leaderName = criteriaBuilder.equal(root.get("projectLeaderName").as(String.class), projectLeaderName);
                predicateList.add(leaderName);
            }

            if (StringUtils.isNotBlank(projectLeaderTel)) {
                Predicate leaderTel = criteriaBuilder.equal(root.get("projectLeaderTel").as(String.class), projectLeaderTel);
                predicateList.add(leaderTel);
            }

            if (!Objects.isNull(businessId)) {
                Predicate businessId1 = criteriaBuilder.equal(root.get("businessId").as(Integer.class), businessId);
                predicateList.add(businessId1);
            }

            if (!Objects.isNull(projectId)) {
                Predicate projectId1 = criteriaBuilder.equal(root.get("projectId").as(Integer.class), projectId);
                predicateList.add(projectId1);
            }

            if (!Objects.isNull(projectCreateUserid)) {
                Predicate projectCreateUserid1 = criteriaBuilder.equal(root.get("projectCreateUserid").as(Integer.class), projectCreateUserid);
                predicateList.add(projectCreateUserid1);
            }

            if (!Objects.isNull(projectCreateTime)) {
                Predicate createTime = criteriaBuilder.equal(root.get("projectCreateTime").as(Date.class), projectCreateTime);
                predicateList.add(createTime);
            }

            if (!Objects.isNull(projectEnddate) && !Objects.isNull(projectStartdate)) {
                Predicate projectEnddate1 = criteriaBuilder.lessThan(root.get("projectEnddate").as(Date.class), projectEnddate);
                Predicate projectStartdate1 = criteriaBuilder.greaterThan(root.get("projectStartdate").as(Date.class), projectStartdate);

                predicateList.add(projectEnddate1);
                predicateList.add(projectStartdate1);
            }

            Predicate[] predicates = new Predicate[predicateList.size()];
            Predicate[] predicateListArray = predicateList.toArray(predicates);
            return criteriaBuilder.and(predicateListArray);
        };

        Integer size = projectCodeDTO.getSize();
        String sortProperties = projectCodeDTO.getSortProperties();
        Sort.Direction direction = projectCodeDTO.getDirection();
        Integer page = projectCodeDTO.getPage();
        Sort orderSort = Sort.by(direction, sortProperties);
        PageRequest requestPage = PageRequest.of(page, size, orderSort);

        Page<TbProjectCode> tbBusinessCodes = tbProjectCodeRepository.findAll(example, requestPage);
        Page<TbProjectCodeDTO> tbProjectCodeDTOS =  modelMapper.map(tbBusinessCodes, Page.class);
        return tbProjectCodeDTOS;
    }


    @Override
    public String getProjectNameById(Long pid) {
        return tbProjectCodeRepository.
                findByProjectId(pid)
                .map(TbProjectCode::getProjectName)
                .orElseGet(String::new);
    }

}
