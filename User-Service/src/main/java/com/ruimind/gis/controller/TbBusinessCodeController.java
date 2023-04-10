package com.ruimind.gis.controller;


import com.ruimind.gis.dto.TbBusinessCodeDTO;
import com.ruimind.gis.dto.TbBusinessNameHistoryDTO;
import com.ruimind.gis.dto.query.PageParamQueryDTO;
import com.ruimind.gis.dto.query.TbBusinessQueryDTO;
import com.ruimind.gis.service.TbBusinessCodeService;
import com.ruimind.gis.service.TbBusinessNameHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@RestController
@Api(tags = "企业信息管理")
@RequestMapping("/v1/tb-business-code")
public class TbBusinessCodeController {


    private final TbBusinessCodeService tbBusinessCodeService;

    private final TbBusinessNameHistoryService tbBusinessNameHistoryService;

    @Autowired
    public TbBusinessCodeController(TbBusinessCodeService tbBusinessCodeService, TbBusinessNameHistoryService tbBusinessNameHistoryService) {
        this.tbBusinessCodeService = tbBusinessCodeService;
        this.tbBusinessNameHistoryService = tbBusinessNameHistoryService;
    }

    @ApiOperation("保存企业信息")
    @PostMapping("/saveBusiness")
    public Boolean addBusiness(@RequestBody @Valid TbBusinessCodeDTO tbBusinessCode) {
        return tbBusinessCodeService.insertBusiness(tbBusinessCode);
    }


    @ApiOperation("更新企业信息")
    @PostMapping("/updateBusiness")
    public Boolean updateBusiness(@RequestBody @Valid TbBusinessCodeDTO tbBusinessCode) {
        return tbBusinessCodeService.updateBusiness(tbBusinessCode);
    }


    @ApiOperation("查询所有企业信息")
    @PostMapping("/findAllBusinessByPage")
    public Page<TbBusinessCodeDTO> findAllBusinessByPage(@RequestBody @Valid  PageParamQueryDTO businessQueryDto) {
        return tbBusinessCodeService.findAllBusinessByPage(businessQueryDto);
    }

    @ApiOperation("根据企业信息查询具体指定信息, 传入那个属性参数就依据那个属性参数查询")
    @PostMapping("/findBusinessByPageQuerySpecifyField")
    public Page<TbBusinessCodeDTO> findAllBusinessByBusinessId(@RequestBody @Valid TbBusinessQueryDTO businessQueryDto) {
        return tbBusinessCodeService.findBusinessByPageQuerySpecifyField(businessQueryDto);
    }


    @ApiOperation("根据企业编号查询名称历史list")
    @GetMapping("/findBusinessHistoryNameByBusinessId/{businessId}")
    public Page<TbBusinessNameHistoryDTO> findBusinessHistoryNameByBusinessId(@PathVariable("businessId") Long businessId) {
        return tbBusinessNameHistoryService.findBusinessHistoryNameByBId(businessId);
    }

    @ApiOperation("删除企业信息")
    @DeleteMapping("/deleteBusinessById/{businessId}")
    public boolean deleteBusinessById(@PathVariable("businessId") Long businessId) {
        return tbBusinessCodeService.deleteBusinessById(businessId);
    }


    @ApiOperation("根据企业ID查询企业名称")
    @GetMapping("/getBusinessNameById/{businessId}")
    public String getBusinessNameById(@PathVariable("businessId") Long businessId) {
        return tbBusinessCodeService.getBusinessNameById(businessId);
    }

}

