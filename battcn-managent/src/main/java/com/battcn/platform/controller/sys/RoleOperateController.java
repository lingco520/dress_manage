package com.battcn.platform.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.battcn.platform.controller.BaseController;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.RoleOperate;
import com.battcn.platform.service.RoleOperateService;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Levin
 */
@Controller
@RequestMapping("/sys/role/operate/")
@ApiIgnore
public class RoleOperateController extends BaseController {

    private final RoleOperateService roleOperateService;

    @Autowired
    public RoleOperateController(RoleOperateService roleOperateService) {
        this.roleOperateService = roleOperateService;
    }

    @GetMapping("{roleId}")
    @ResponseBody
    public ApiResult<List<RoleOperate>> listOperate(@PathVariable Integer roleId) {
        return ApiResult.getSuccess(this.roleOperateService.listRoleOperateByRoleId(roleId));
    }

    @PostMapping("permissions")
    @ResponseBody
    public ApiResult<String> savePermissions(Integer[] operateId, Integer roleId) {
        logger.debug("[数据] - [{}] - [{}]", JSON.toJSONString(operateId), roleId);
        return this.roleOperateService.batchInsertRoleOperate(operateId, roleId);
    }

}
