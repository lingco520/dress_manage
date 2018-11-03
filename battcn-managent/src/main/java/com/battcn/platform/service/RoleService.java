package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.po.Role;

/**
 * @author Levin
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 查询所有角色,根据ID排序
     *
     * @return 查询结果
     */
    List<Role> listRole();

    /**
     * 批量删除
     *
     * @param ids ID集
     */
    void deleteRoleAndOperate(Integer[] ids);

}
