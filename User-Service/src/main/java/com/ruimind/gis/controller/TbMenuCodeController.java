package com.ruimind.gis.controller;


import com.ruimind.gis.dto.TbMenuCodeDTO;
import com.ruimind.gis.service.TbMenuCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dongwentao
 * @since 2023-04-06
 */
@RestController
@Api(tags = "菜单管理")
@RequestMapping("/tb-menu-code")
public class TbMenuCodeController {


    private final TbMenuCodeService tbMenuCodeService;

    @Autowired
    public TbMenuCodeController(TbMenuCodeService tbMenuCodeService) {
        this.tbMenuCodeService = tbMenuCodeService;
    }

    @ApiOperation("添加菜单信息")
    @PostMapping("/saveMenu")
    public Boolean saveMenu(@RequestBody @Valid TbMenuCodeDTO tbMenuCodeDTO) {
        return tbMenuCodeService.insertMenu(tbMenuCodeDTO);
    }


    @ApiOperation("修改菜单信息")
    @PostMapping("/updateMenu")
    public Boolean updateMenu(@RequestBody @Valid TbMenuCodeDTO tbMenuCodeDTO) {
        return tbMenuCodeService.updateMenu(tbMenuCodeDTO);
    }


    @ApiOperation("删除菜单信息")
    @DeleteMapping("/deleteMenuById/{mid}")
    public boolean deleteMenuById(@PathVariable("mid") Long pid) {
        return tbMenuCodeService.deleteMenuById(pid);
    }

    @ApiOperation("获取所有菜单的树形结构")
    @GetMapping("/findMenuTree")
    public List<TbMenuCodeDTO> findMenuTree() {
        return tbMenuCodeService.findMenuTree();
    }

}

