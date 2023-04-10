package com.ruimind.gis.controller;


import com.ruimind.gis.dto.TbLogCodeDTO;
import com.ruimind.gis.dto.query.TbLogCodeQueryDTO;
import com.ruimind.gis.service.TbLogCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "日志管理")
@RequestMapping("/v1/tb-log-code")
public class TbLogCodeController {


    private final TbLogCodeService tbLogCodeService;

    @Autowired
    public TbLogCodeController(TbLogCodeService tbLogCodeService) {
        this.tbLogCodeService = tbLogCodeService;
    }

    @ApiOperation("保存日志信息")
    @PostMapping("/saveLog")
    public Boolean addLog(@RequestBody @Valid TbLogCodeDTO tbLogCodeDTO) {
        return tbLogCodeService.insertLog(tbLogCodeDTO);
    }


    @ApiOperation("根据日志信息查询具体指定信息, 传入那个属性参数就依据那个属性参数查询")
    @PostMapping("/findLogByPageQuerySpecifyField")
    public Page<TbLogCodeDTO> findAllBusinessByBusinessId(@RequestBody @Valid TbLogCodeQueryDTO tbLogCodeQueryDTO) {
        return tbLogCodeService.finLogByPageQuerySpecifyField(tbLogCodeQueryDTO);
    }
}

