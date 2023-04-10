package com.ruimind.gis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruimind.gis.dto.TbBusinessNameHistoryDTO;
import com.ruimind.gis.entity.TbBusinessNameHistory;
import com.ruimind.gis.mapper.TbBusinessNameHistoryMapper;
import com.ruimind.gis.repository.TbBusinessNameHistoryRepository;
import com.ruimind.gis.service.TbBusinessNameHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
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
public class TbBusinessNameHistoryServiceImpl extends ServiceImpl<TbBusinessNameHistoryMapper, TbBusinessNameHistory> implements TbBusinessNameHistoryService {


    private final TbBusinessNameHistoryMapper tbBusinessNameHistoryMapper;

    private final TbBusinessNameHistoryRepository tbBusinessNameHistoryRepository;

    private final static ModelMapper mapper = new ModelMapper();

    @Autowired
    public TbBusinessNameHistoryServiceImpl(TbBusinessNameHistoryMapper tbBusinessNameHistoryMapper,
                                            TbBusinessNameHistoryRepository tbBusinessNameHistoryRepository) {
        this.tbBusinessNameHistoryMapper = tbBusinessNameHistoryMapper;
        this.tbBusinessNameHistoryRepository = tbBusinessNameHistoryRepository;
    }

    @Override
    public Page<TbBusinessNameHistoryDTO> findBusinessHistoryNameByBId(Long businessId) {
        Sort orders = Sort.by(Sort.Direction.ASC, "businessNameHistoryId");
        PageRequest request = PageRequest.of(0, 20, orders);

        Page<TbBusinessNameHistory> historyBusinessNameByBusinessId =
                tbBusinessNameHistoryRepository.findHistoryBusinessNameByBusinessId(businessId, request);

        Page<TbBusinessNameHistoryDTO> tbBusinessNameHistoryDTOS = mapper.map(historyBusinessNameByBusinessId, Page.class);
        return tbBusinessNameHistoryDTOS;
    }

    @Override
    public boolean deleteBusinessHistoryNameById(Long bid) {

        List<TbBusinessNameHistory> tbBusinessNameHistories = tbBusinessNameHistoryRepository.findByBusinessId(bid);

        AtomicBoolean isDeleted = new AtomicBoolean(false);

        if(!CollectionUtils.isEmpty(tbBusinessNameHistories)) {
            tbBusinessNameHistories.forEach((businessNameHistory)->{
                businessNameHistory.setIsDeleted((byte)0);
                isDeleted.set(tbBusinessNameHistoryRepository.save(businessNameHistory).getIsDeleted() != 1);
            });
        }

        return isDeleted.get();
    }
}
