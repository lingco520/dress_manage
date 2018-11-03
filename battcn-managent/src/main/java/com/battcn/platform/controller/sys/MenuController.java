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
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.service.MenuService;
import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

import static com.battcn.framework.common.exception.BattcnException.notFound;


/**
 * @author Levin
 */
@Controller
@RequestMapping("/sys/menu")
@Api(value = "菜单管理")
@ApiIgnore
public class MenuController extends BaseController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String list(DataGrid grid) {
        request.setAttribute("page", this.menuService.listMenuForDataGrid(grid));
        return "sys/menu/list";
    }

    @GetMapping(value = "/edit")
    public String edit(Integer id) {
        if (id != null) {
            request.setAttribute("dto", this.menuService.selectById(id).orElseThrow(() -> notFound("该数据已失效")));
        }
        request.setAttribute("menus", this.menuService.listMenu());
        return "sys/menu/edit";
    }

    @BattcnLog(module = "菜单管理", methods = "保存菜单", description = "添加/修改菜单信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public ApiResult<String> save(Menu menu) {
        if (menu != null) {
            this.menuService.saveOrUpdate(menu);
        }
        return ApiResult.SUCCESS;
    }

    @BattcnLog(module = "菜单管理", methods = "移除菜单", description = "删除菜单信息")
    @PostMapping(value = "/remove")
    @ResponseBody
    public ApiResult<String> del(Integer[] ids) {
        Lists.newArrayList(ids).forEach(this.menuService::deleteById);
        return ApiResult.SUCCESS;
    }


}
