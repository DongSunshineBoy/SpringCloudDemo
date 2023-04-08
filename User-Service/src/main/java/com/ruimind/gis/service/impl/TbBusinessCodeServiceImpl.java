package com.ruimind.gis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruimind.gis.dto.TbBusinessCodeDTO;
import com.ruimind.gis.dto.query.PageParamQueryDTO;
import com.ruimind.gis.dto.query.TbBusinessQueryDTO;
import com.ruimind.gis.entity.TbBusinessCode;
import com.ruimind.gis.entity.TbBusinessNameHistory;
import com.ruimind.gis.mapper.TbBusinessCodeMapper;
import com.ruimind.gis.repository.TbBusinessCodeRepository;
import com.ruimind.gis.repository.TbBusinessNameHistoryRepository;
import com.ruimind.gis.service.TbBusinessCodeService;
import com.ruimind.gis.service.TbBusinessNameHistoryService;
import lombok.extern.slf4j.Slf4j;
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
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@Service
@Slf4j
public class TbBusinessCodeServiceImpl extends
        ServiceImpl<TbBusinessCodeMapper, TbBusinessCode> implements TbBusinessCodeService {

    TbBusinessCodeMapper tbBusinessCodeMapper;
    TbBusinessCodeRepository tbBusinessCodeRepository;
    TbBusinessNameHistoryService tbBusinessNameHistoryService;
    TbBusinessNameHistoryRepository tbBusinessNameHistoryRepository;

    @Autowired
    public TbBusinessCodeServiceImpl(TbBusinessCodeMapper tbBusinessCodeMapper,
                                     TbBusinessCodeRepository tbBusinessCodeRepository,
                                     TbBusinessNameHistoryService tbBusinessNameHistoryService,
                                     TbBusinessNameHistoryRepository tbBusinessNameHistoryRepository) {
        this.tbBusinessCodeMapper = tbBusinessCodeMapper;
        this.tbBusinessCodeRepository = tbBusinessCodeRepository;
        this.tbBusinessNameHistoryService = tbBusinessNameHistoryService;
        this.tbBusinessNameHistoryRepository = tbBusinessNameHistoryRepository;
    }

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBusiness(TbBusinessCodeDTO tbBusinessCodeDTO) {
        TbBusinessCode tbBusinessCode = modelMapper.map(tbBusinessCodeDTO, TbBusinessCode.class);

        Long businessId = tbBusinessCode.getBusinessId();

        TbBusinessNameHistory tbBusinessNameHistory = new TbBusinessNameHistory();
        tbBusinessNameHistory
                .setBusinessId(businessId)
                .setBusinessName(tbBusinessCode.getBusinessName())
                .setStarttime(new Date());

        Long historyBusinessId = tbBusinessNameHistoryRepository.save(tbBusinessNameHistory).getBusinessId();

        if (businessId.equals(historyBusinessId)) {
            log.debug("save {} history info successfully", tbBusinessNameHistory);
        }

        return tbBusinessCodeRepository.save(tbBusinessCode).getBusinessId() != null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBusiness(TbBusinessCodeDTO tbBusinessCodeDTO) {

        TbBusinessCode tbBusinessCode = modelMapper.map(tbBusinessCodeDTO, TbBusinessCode.class);

        Long businessId = tbBusinessCode.getBusinessId();

        Optional<TbBusinessNameHistory> historyRepositoryByBusiness = tbBusinessNameHistoryRepository.findByBusinessId(businessId);

        Long historyBusinessId = historyRepositoryByBusiness.map(TbBusinessNameHistory::getBusinessId).orElseGet(() -> 0L);

        //如果修改后的企业名称与历史企业名称不相同
        if (!historyBusinessId.equals(businessId) && historyRepositoryByBusiness.isPresent()
                && historyRepositoryByBusiness.get().getEndtime() == null) {

            //修改旧的记录的结束时间
            TbBusinessNameHistory businessNameHistory = historyRepositoryByBusiness.get();
            businessNameHistory.setEndtime(new Date());
            TbBusinessNameHistory updateOldHistoryInfo = tbBusinessNameHistoryRepository.save(businessNameHistory);
            Long updateId = updateOldHistoryInfo.getBusinessId();

            if (updateId.equals(businessNameHistory.getBusinessId())) {
                log.debug("save {} history business information successfully and update end time", updateOldHistoryInfo);
            }

            //保存新的企业历史记录信息
            TbBusinessNameHistory tbBusinessNameHistory = new TbBusinessNameHistory();
            tbBusinessNameHistory
                    .setBusinessId(businessId)
                    .setBusinessName(tbBusinessCode.getBusinessName())
                    .setStarttime(new Date());

            Long historyBsId = tbBusinessNameHistoryRepository.save(tbBusinessNameHistory).getBusinessId();

            //判断是否保存成功
            if (businessId.equals(historyBsId)) {
                log.debug("save {} history info successfully", tbBusinessNameHistory);
            }
        }

        //保存信息到企业表中一份
        return tbBusinessCodeRepository.save(tbBusinessCode).getBusinessId() != null;
    }

    @Override
    public Page<TbBusinessCodeDTO> findAllBusinessByPage(PageParamQueryDTO pageRequest) {

        Integer page = pageRequest.getPage();
        Integer size = pageRequest.getSize();
        Sort.Direction direction = pageRequest.getDirection();
        String sort = pageRequest.getSortProperties();
        Sort sorted = Sort.by(direction, sort);
        PageRequest request = PageRequest.of(page, size, sorted);
        Page<TbBusinessCode> tbBusinessCodes = tbBusinessCodeRepository.findAll(request);
        Page<TbBusinessCodeDTO> tbBusinessCodeDTOPage = modelMapper.map(tbBusinessCodes, Page.class);
        return tbBusinessCodeDTOPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<TbBusinessCodeDTO> findAllBusinessByPageQueryParams(TbBusinessQueryDTO pageRequest) {

        String businessArea = pageRequest.getBusinessArea();
        Integer businessDeleted = pageRequest.getBusinessDeleted();
        Integer businessType = pageRequest.getBusinessType();
        String businessNameAbbr = pageRequest.getBusinessNameAbbr();
        Long businessId = pageRequest.getBusinessId();
        String businessContactsTel = pageRequest.getBusinessContactsTel();
        String businessContactsName = pageRequest.getBusinessContactsName();

        Integer page = pageRequest.getPage();
        Integer size = pageRequest.getSize();
        Sort.Direction direction = pageRequest.getDirection();
        String sortProperties = pageRequest.getSortProperties();

        Specification<TbBusinessCode> example = (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(businessArea)) {
                Predicate businessArea1 = criteriaBuilder.equal(root.get("businessArea").as(String.class), businessArea);
                predicateList.add(businessArea1);
            }

            if (StringUtils.isNotBlank(businessContactsName)) {
                Predicate businessContactsName1 = criteriaBuilder.equal(root.get("businessContactsName").as(String.class), businessContactsName);
                predicateList.add(businessContactsName1);
            }

            if (StringUtils.isNotBlank(businessContactsTel)) {
                Predicate businessContactsTel1 = criteriaBuilder.equal(root.get("businessContactsTel").as(String.class), businessContactsTel);
                predicateList.add(businessContactsTel1);
            }

            if (!Objects.isNull(businessId)) {
                Predicate businessId1 = criteriaBuilder.equal(root.get("businessId").as(Integer.class), businessId);
                predicateList.add(businessId1);
            }

            if (!Objects.isNull(businessType)) {
                Predicate businessType1 = criteriaBuilder.equal(root.get("businessType").as(Integer.class), businessType);
                predicateList.add(businessType1);
            }

            if (!Objects.isNull(businessDeleted)) {
                Predicate businessDeleted1 = criteriaBuilder.equal(root.get("businessDeleted").as(Integer.class), businessDeleted);
                predicateList.add(businessDeleted1);
            }

            if (StringUtils.isNotBlank(businessNameAbbr)) {
                Predicate businessNameAbbr1 = criteriaBuilder.equal(root.get("businessNameAbbr").as(String.class), businessNameAbbr);
                predicateList.add(businessNameAbbr1);
            }

            Predicate[] predicates = new Predicate[predicateList.size()];
            Predicate[] predicateListArray = predicateList.toArray(predicates);
            return criteriaBuilder.or(predicateListArray);
        };

        Sort orders = Sort.by(direction, sortProperties);
        PageRequest request = PageRequest.of(page, size, orders);

        Page<TbBusinessCode> tbBusinessCodes = tbBusinessCodeRepository.findAll(example, request);
        return modelMapper.map(tbBusinessCodes, Page.class);
    }

}