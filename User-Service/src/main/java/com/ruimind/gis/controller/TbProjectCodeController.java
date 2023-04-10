package com.ruimind.gis.controller;


import com.ruimind.gis.dto.TbProjectCodeDTO;
import com.ruimind.gis.dto.query.TbProjectCodeQueryDTO;
import com.ruimind.gis.service.TbProjectCodeService;
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
@Api(tags = "项目管理")
@RequestMapping("/v1/tb-project-code")
public class TbProjectCodeController {


    private final TbProjectCodeService tbProjectCodeService;

    @Autowired
    public TbProjectCodeController(TbProjectCodeService tbProjectCodeService) {
        this.tbProjectCodeService = tbProjectCodeService;
    }

    @ApiOperation("添加项目信息")
    @PostMapping("/saveProject")
    public Boolean saveProject(@RequestBody @Valid TbProjectCodeDTO tbProjectCodeDTO) {
        return tbProjectCodeService.insertProject(tbProjectCodeDTO);
    }


    @ApiOperation("修改项目信息")
    @PostMapping("/updateProject")
    public Boolean updateProject(@RequestBody @Valid TbProjectCodeDTO tbProjectCodeDTO) {
        return tbProjectCodeService.updateProject(tbProjectCodeDTO);
    }


    @ApiOperation("删除项目信息")
    @DeleteMapping("/deleteProjectById/{pid}")
    public boolean deleteBusinessById(@PathVariable("pid") Long pid) {
        return tbProjectCodeService.deleteProjectByPid(pid);
    }


    @ApiOperation("根据项目信息查询具体指定信息")
    @PostMapping("/findProjectByPageQuerySpecifyField")
    public Page<TbProjectCodeDTO> findProjectByPageQuerySpecifyField(@RequestBody @Valid TbProjectCodeQueryDTO tbProjectCodeQueryDTO) {
        return tbProjectCodeService.findProjectByPageQuerySpecifyField(tbProjectCodeQueryDTO);
    }


    @ApiOperation("根据项目ID查询项目名称")
    @GetMapping("/getProjectNameById/{pid}")
    public String getBusinessNameById(@PathVariable("pid") Long businessId) {
        return tbProjectCodeService.getProjectNameById(businessId);
    }

}

