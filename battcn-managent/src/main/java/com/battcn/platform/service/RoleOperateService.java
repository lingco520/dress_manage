package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.RoleOperate;

/**
 * @author Levin
 */
public interface RoleOperateService extends BaseService<RoleOperate> {

    /**
     * 根据角色ID查询 角色操作信息
     *
     * @param roleId 角色ID
     * @return 查询结果
     */
    List<RoleOperate> listRoleOperateByRoleId(Integer roleId);

    /**
     * 批量添加 角色操作信息
     *
     * @param operateId 操作ID
     * @param roleId    角色ID
     * @return 操作结果
     */
    ApiResult<String> batchInsertRoleOperate(Integer[] operateId, Integer roleId);

}
