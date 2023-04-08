package com.ruimind.gis;

import com.ruimind.gis.entity.*;
import com.ruimind.gis.repository.TbAccountCodeRepository;
import com.ruimind.gis.service.TbAccountCodeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TbAccountServiceImplTest {

    @Autowired
    private TbAccountCodeService tbAccountCodeService;

    @Autowired
    private TbAccountCodeRepository tbAccountCodeRepository;

    @Test
    @Order(1)
    @Transactional(rollbackFor = Exception.class)
    @Commit
    public void testInsert() {

        List<TbAccountPermissionCode> tbAccountPermissionCodes = new ArrayList<>();
        List<TbAccountMapinfoCode> tbAccountMapinfoCodes = new ArrayList<>();
        TbProjectCode tbProjectCode = new TbProjectCode();
        List<TbUserAccountRoleCode> tbUserAccountRoleCodes = new ArrayList<>();
        List<TbUserAccountRoleHistory> tbUserAccountRoleHistories = new ArrayList<>();

        for (int i = 3; i < 6; i++) {
            TbAccountPermissionCode tbAccountPermissionCode = new TbAccountPermissionCode();
            tbAccountPermissionCode
                    .setRoleId(1)
                    .setMenuId(1)
                    .setCreateUserid(1)
                    .setCreateTime(new Date());
            tbAccountPermissionCodes.add(tbAccountPermissionCode);

            TbAccountMapinfoCode tbAccountMapinfoCode = new TbAccountMapinfoCode();
            tbAccountMapinfoCode
                    .setMapinfoId(1L)
                    .setCreateUserid(1L)
                    .setCreateTime(new Date())
                    .setRoleId((long)1);
            tbAccountMapinfoCodes.add(tbAccountMapinfoCode);


            TbUserAccountRoleCode tbUserAccountRoleCode = new TbUserAccountRoleCode();
            tbUserAccountRoleCode.setUserId((long)1)
                    .setRoleId((long)1)
                    .setCreateUserid(1L)
                    .setUserId((long)1);
            tbUserAccountRoleCodes.add(tbUserAccountRoleCode);

            TbUserAccountRoleHistory tbUserAccountRoleHistory = new TbUserAccountRoleHistory();
            tbUserAccountRoleHistory
                    .setEndtime(new Date())
                    .setStarttime(new Date())
                    .setRoleId((long) 1);
            tbUserAccountRoleHistories.add(tbUserAccountRoleHistory);
        }

        tbProjectCode.
                setProjectName("开源项目")
                .setProjectLeaderName("董文涛")
                .setBusinessId(1L)
                .setProjectCreateTime(new Date())
                .setProjectEnddate(new Date())
                .setProjectCreateUserid(1L);

        TbAccountCode tbAccountCode = new TbAccountCode();
        tbAccountCode.setCreateTime(new Date())
                .setCreateUserid(1L)
                .setBusinessId(1L)
                .setProjectId(14L)
                .setTbAccountPermissionCode(tbAccountPermissionCodes)
                .setTbAccountMapinfoCodes(tbAccountMapinfoCodes)
                .setTbProjectCode(tbProjectCode)
                .setTbUserAccountRoleCode(tbUserAccountRoleCodes)
                .setTbUserAccountRoleHistories(tbUserAccountRoleHistories);

        Long accountId = tbAccountCodeRepository.save(tbAccountCode).getAccountId();

        Assertions.assertNotNull(accountId, "租户信息保存成功!");
    }

    @Test
    @Order(2)
    @Transactional(rollbackFor = Exception.class)
    @Commit
    public void testUpdate() throws Throwable {

        Iterable<TbAccountCode> tbAccountCodes = tbAccountCodeRepository.findAll();

        Optional.of(tbAccountCodes).map((Function<Iterable<TbAccountCode>, Object>) tbAccountCodes1 -> {
            tbAccountCodes1.forEach((accountCode) -> {
                accountCode
                        .setCreateUserid(10L)
                        .setCreateTime(new Date());
                Long accountId = tbAccountCodeRepository.save(accountCode).getCreateUserid();

                Assertions.assertEquals(accountId, 10L, "更新租户信息成功！");
            });
            return tbAccountCodes1;
        }).orElseGet((Supplier<Iterable<TbAccountCode>>) ArrayList::new);
    }

    @Test
    @Order(3)
    @Transactional(rollbackFor = Exception.class)
    @Commit
    public void testFind() {
        Iterable<TbAccountCode> all = tbAccountCodeRepository.findAll();
        for (TbAccountCode tbAccountCode : all) log.debug(tbAccountCode.toString());
        log.debug(all.toString());
        Assertions.assertNotNull(all, "租户信息不为空!");
    }


    @Test
    @Order(4)
    @Transactional(rollbackFor = Exception.class)
    @Commit
    public void testDelete() {
        Optional<TbAccountCode> byAccountId = tbAccountCodeRepository.findByAccountId(38L);
        byAccountId.map((Function<TbAccountCode, Object>) tbAccountCode -> {
            tbAccountCode.setIsDeleted(false);
            Boolean isDeleted = tbAccountCodeRepository.save(tbAccountCode).getIsDeleted();
            Assertions.assertFalse(isDeleted, "租户信息删除成功!");
            return tbAccountCode;
        }).orElseGet(TbAccountCode::new);
    }

}
