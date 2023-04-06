package com.ruimind.gis;

import com.ruimind.gis.entity.TbAccountCode;
import com.ruimind.gis.entity.TbBusinessCode;
import com.ruimind.gis.entity.TbProjectCode;
import com.ruimind.gis.mapper.TbBusinessCodeMapper;
import com.ruimind.gis.repository.TbAccountCodeRepository;
import com.ruimind.gis.repository.TbBusinessCodeRepository;
import com.ruimind.gis.service.TbAccountCodeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

    @Autowired
    private TbAccountCodeService tbAccountCodeService;

    @Autowired
    private TbAccountCodeRepository tbAccountCodeRepository;

    @Autowired
    private TbBusinessCodeMapper tbBusinessCodeMapper;

    @Autowired
    private TbBusinessCodeRepository tbBusinessCodeRepository;

    @Test
    void testTbAccountInsert() {

        List<TbAccountCode> accountCodes = new ArrayList<>();

        List<TbProjectCode> tbProjectCodes = new ArrayList<>();

        for (int i = 2; i < 10; i++) {
            TbAccountCode tbBusinessCode = new TbAccountCode();
            tbBusinessCode
                    .setCreateTime(new Date())
                    .setProjectId((long) i)
                    .setCreateUserid((long) i);

            accountCodes.add(tbBusinessCode);

            TbProjectCode tbProjectCode = new TbProjectCode();
            tbProjectCode
                    .setBusinessId(6L)
                    .setProjectEnddate(new Date())
                    .setProjectCreateTime(new Date())
                    .setProjectName("开源项目"+ i)
                    .setProjectLeaderName("dwt");

            tbProjectCodes.add(tbProjectCode);
        }

        TbBusinessCode tbBusinessCode = new TbBusinessCode();
        tbBusinessCode.setBusinessArea("陕西省")
                 .setBusinessName("睿智")
                 .setBusinessDeleted(1)
                 .setBusinessType(1)
                 .setBusinessNameAbbr("陕西省软件圆")
                .setTbAccountCodeList(accountCodes)
                .setProjectCodeList(tbProjectCodes);


        Long accountId = tbBusinessCodeRepository.save(tbBusinessCode).getBusinessId();

        Assertions.assertNotNull(accountId, "插入数据成功！");
    }

    @Test
    void testTbAccountUpdate() {

        List<TbAccountCode> accountCodes = new ArrayList<>();

        List<TbProjectCode> tbProjectCodes = new ArrayList<>();

        for (int i = 2; i < 10; i++) {
            TbAccountCode tbBusinessCode = new TbAccountCode();
            tbBusinessCode
                    .setCreateTime(new Date())
                    .setProjectId((long) i)
                    .setCreateUserid((long) i);

            accountCodes.add(tbBusinessCode);

            TbProjectCode tbProjectCode = new TbProjectCode();
            tbProjectCode
                    .setProjectId((long)i)
                    .setBusinessId(6L)
                    .setProjectEnddate(new Date())
                    .setProjectCreateTime(new Date())
                    .setProjectName("开源项目")
                    .setProjectLeaderName("dwt");

            tbProjectCodes.add(tbProjectCode);
        }



        TbBusinessCode tbBusinessCode = new TbBusinessCode();
        tbBusinessCode.setBusinessId(6L).
                setBusinessArea("陕西省")
                .setBusinessName("睿智有限责任公司")
                .setBusinessDeleted(1)
                .setBusinessType(1)
                .setBusinessNameAbbr("陕西省软件圆A座")
                .setTbAccountCodeList(accountCodes)
                .setProjectCodeList(tbProjectCodes);

        Long accountId = tbBusinessCodeRepository.save(tbBusinessCode).getBusinessId();
        Assertions.assertNotNull(accountId, "更新数据成功！");
    }


    @Test
    @Transactional
    void testTbAccountFind() {
        Optional<TbBusinessCode> byId = tbBusinessCodeRepository.findByBusinessId(6L);
        Assertions.assertNotNull(byId.get(), "查询数据成功！");
        log.info(byId.get().toString());
    }

    @Test
    @Transactional
    void testTbAccountDelete() {
        tbBusinessCodeRepository.deleteById(4L);
        Optional<TbBusinessCode> byId = tbBusinessCodeRepository.findById(6L);
        Assertions.assertNull(byId.get(), "查询数据成功！");
    }

}
