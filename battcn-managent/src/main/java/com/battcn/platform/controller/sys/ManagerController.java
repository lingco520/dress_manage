package com.battcn.platform.controller.sys;

import com.battcn.framework.common.exception.BattcnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.dto.ManagerDto;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.Manager;
import com.battcn.platform.service.ManagerService;
import com.battcn.platform.service.RoleService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;


/**
 * @author Levin
 */
@Controller
@RequestMapping("/sys/manager")
@Api(value = "用户管理", description = "用户管理", tags = "1.2")
public class ManagerController extends BaseController {

    private final ManagerService managerService;
    private final RoleService roleService;

    @Autowired
    public ManagerController(ManagerService managerService, RoleService roleService) {
        this.managerService = managerService;
        this.roleService = roleService;
    }

    @ApiIgnore
    @GetMapping("/list")
    public String list() {
        return "sys/manager/list";
    }

    @ApiIgnore
    @GetMapping(value = "/edit")
    public String edit(Integer id) {
        if (id != null) {
            request.setAttribute("dto", this.managerService.selectById(id).orElseThrow(() -> BattcnException.notFound("该数据已失效")));
        }
        request.setAttribute("roles", this.roleService.listRole());
        return "sys/manager/edit";
    }

    @ApiOperation(value = "带条件分页查询")
    @GetMapping(value = "/query")
    @ResponseBody
    public PageInfo<ManagerDto> query(DataGrid grid, String name, String account) {
        return this.managerService.listManagerByName(grid, name, account);
    }

    @ApiOperation(value = "添加/修改用户信息")
    @BattcnLog(module = "用户管理", methods = "保存用户", description = "添加/修改用户信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public ApiResult<Manager> save(Manager dto) {
        dto.setGmtModified(new Date());
        if (dto.getId() != null) {
            return ApiResult.getResponse(this.managerService.updateSelectiveById(dto));
        }
        return ApiResult.getResponse(this.managerService.insertSelective(dto));
    }

    @ApiOperation(value = "删除用户信息")
    @BattcnLog(module = "用户管理", methods = "移除用户", description = "删除用户信息")
    @PostMapping(value = "/remove")
    @ResponseBody
    public ApiResult<String> del(Integer[] ids) {
        Lists.newArrayList(ids).forEach(this.managerService::deleteById);
        return ApiResult.SUCCESS;
    }

}
