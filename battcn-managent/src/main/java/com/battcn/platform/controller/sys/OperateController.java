package com.battcn.platform.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battcn.framework.common.annotation.BattcnLog;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.dto.OperateDto;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.Operate;
import com.battcn.platform.service.MenuService;
import com.battcn.platform.service.OperateService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

import static com.battcn.framework.common.exception.BattcnException.notFound;

/**
 * @author Levin
 */
@Controller
@RequestMapping("/sys/operate")
@ApiIgnore
public class OperateController extends BaseController {

    private final MenuService menuService;
    private final OperateService operateService;

    @Autowired
    public OperateController(OperateService operateService, MenuService menuService) {
        this.operateService = operateService;
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String list() {
        return "sys/operate/list";
    }

    @GetMapping(value = "/edit")
    public String edit(Integer id, HttpServletRequest request) {
        if (id != null) {
            request.setAttribute("dto", this.operateService.selectById(id).orElseThrow(() -> notFound("该数据已失效")));
        }
        request.setAttribute("menus", this.menuService.listMenu());
        return "sys/operate/edit";
    }

    @GetMapping(value = "/query")
    @ResponseBody
    public PageInfo<OperateDto> query(DataGrid grid) {
        return this.operateService.listOperateByPage(grid);
    }

    @BattcnLog(module = "操作管理", methods = "保存操作", description = "添加/修改操作信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public ApiResult<String> save(Operate dto) {
        if (dto != null && dto.getId() != null) {
            return ApiResult.getResponse(this.operateService.updateSelectiveById(dto));
        }
        return ApiResult.getResponse(this.operateService.insertSelective(dto));
    }

    @BattcnLog(module = "操作管理", methods = "移除操作", description = "删除操作信息")
    @PostMapping(value = "/remove")
    @ResponseBody
    public ApiResult<String> del(Integer[] ids) {
        Lists.newArrayList(ids).forEach(this.operateService::deleteById);
        return ApiResult.SUCCESS;
    }

}
