package com.ruimind.gis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruimind.gis.dto.TbLogCodeDTO;
import com.ruimind.gis.dto.query.TbLogCodeQueryDTO;
import com.ruimind.gis.entity.TbLogCode;
import com.ruimind.gis.mapper.TbLogCodeMapper;
import com.ruimind.gis.repository.TbLogCodeRepository;
import com.ruimind.gis.service.TbLogCodeService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@Service
public class TbLogCodeServiceImpl extends ServiceImpl<TbLogCodeMapper, TbLogCode> implements TbLogCodeService {

    private final TbLogCodeMapper tbLogCodeMapper;
    private final TbLogCodeRepository tbLogCodeRepository;

    private final static ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public TbLogCodeServiceImpl(TbLogCodeMapper tbLogCodeMapper, TbLogCodeRepository tbLogCodeRepository) {
        this.tbLogCodeMapper = tbLogCodeMapper;
        this.tbLogCodeRepository = tbLogCodeRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertLog(TbLogCodeDTO tbLogCodeDTO) {
        TbLogCode tbLogCode = modelMapper.map(tbLogCodeDTO, TbLogCode.class);
        return tbLogCodeRepository.save(tbLogCode).getLogId() != null;
    }

    @Override
    public Page<TbLogCodeDTO> finLogByPageQuerySpecifyField(TbLogCodeQueryDTO tbLogCodeQueryDTO) {

        Date logDatetime = tbLogCodeQueryDTO.getLogDatetime();

        Long logOperateUserid = tbLogCodeQueryDTO.getLogOperateUserid();

        String logIp = tbLogCodeQueryDTO.getLogIp();

        Long logId = tbLogCodeQueryDTO.getLogId();

        String loginStatus = tbLogCodeQueryDTO.getLoginStatus();

        Integer logType = tbLogCodeQueryDTO.getLogType();

        Integer page = tbLogCodeQueryDTO.getPage();
        Integer size = tbLogCodeQueryDTO.getSize();
        String sortProperties = tbLogCodeQueryDTO.getSortProperties();
        Sort.Direction direction = tbLogCodeQueryDTO.getDirection();


        Specification<TbLogCode> example = (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(logIp)) {
                Predicate projectName1 = criteriaBuilder.like(root.get("logIp").as(String.class), logIp);
                predicateList.add(projectName1);
            }

            if (StringUtils.isNotBlank(loginStatus)) {
                Predicate leaderName = criteriaBuilder.equal(root.get("loginStatus").as(String.class), loginStatus);
                predicateList.add(leaderName);
            }


            if (!Objects.isNull(logId)) {
                Predicate businessId1 = criteriaBuilder.equal(root.get("logId").as(Integer.class), logId);
                predicateList.add(businessId1);
            }

            if (!Objects.isNull(logDatetime)) {
                Predicate projectId1 = criteriaBuilder.equal(root.get("logDatetime").as(Date.class), logDatetime);
                predicateList.add(projectId1);
            }

            if (!Objects.isNull(logOperateUserid)) {
                Predicate projectCreateUserid1 = criteriaBuilder.equal(root.get("logOperateUserid").as(Integer.class), logOperateUserid);
                predicateList.add(projectCreateUserid1);
            }

            if (!Objects.isNull(logType)) {
                Predicate createTime = criteriaBuilder.equal(root.get("logType").as(Date.class), logType);
                predicateList.add(createTime);
            }

            Predicate[] predicates = new Predicate[predicateList.size()];
            Predicate[] predicateListArray = predicateList.toArray(predicates);
            return criteriaBuilder.and(predicateListArray);
        };


        Sort orders = Sort.by(direction, sortProperties);
        PageRequest request = PageRequest.of(page, size, orders);

        Page<TbLogCode> tbLogCodes = tbLogCodeRepository.findAll(example, request);
        Page<TbLogCodeDTO> tbLogCodeDTOS = modelMapper.map(tbLogCodes, Page.class);
        return tbLogCodeDTOS;
    }
}
