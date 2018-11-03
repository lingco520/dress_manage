package com.battcn.platform.service;

import java.util.List;

import com.battcn.framework.common.model.TreeNode;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.dto.PermissionDto;
import com.battcn.platform.pojo.po.Menu;
import com.github.pagehelper.PageInfo;

/**
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface MenuService extends BaseService<Menu> {

    /**
     * 分页查询 菜单列表
     *
     * @param grid 分页信息
     * @return 查询结果
     */
    PageInfo<Menu> listMenuForDataGrid(DataGrid grid);

    /**
     * 根据角色ID获取树形结构的菜单数据
     *
     * @param roleId 角色ID
     * @return 查询结果
     */
    List<TreeNode> listTree(Integer roleId);

    /**
     * 查询所有权限信息
     *
     * @return 查询结果
     */
    List<PermissionDto> listPermissions();

    /**
     * 查询所有菜单
     *
     * @return 查询结果
     */
    List<Menu> listMenu();

    /**
     * 根据菜单编号判断 添加/保存 菜单信息
     *
     * @param menu 菜单
     */
    void saveOrUpdate(Menu menu);

}
