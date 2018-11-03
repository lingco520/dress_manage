package com.battcn.platform.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battcn.framework.common.model.TreeNode;
import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.AuthMapper;
import com.battcn.platform.mapper.MenuMapper;
import com.battcn.platform.mapper.OperateMapper;
import com.battcn.platform.pojo.dto.PermissionDto;
import com.battcn.platform.pojo.po.Menu;
import com.battcn.platform.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import tk.mybatis.orderbyhelper.OrderByHelper;

/**
 * @author Levin
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    private final AuthMapper authMapper;
    private final OperateMapper operateMapper;
    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(AuthMapper authMapper, OperateMapper operateMapper, MenuMapper menuMapper) {
        this.authMapper = authMapper;
        this.operateMapper = operateMapper;
        this.menuMapper = menuMapper;

    }

    private List<TreeNode> createTree(List<Menu> menus, Integer pid) {
        return menus.stream().filter(m -> m.getPaterId() != null && Objects.equals(pid, m.getPaterId()))
                .map(m -> new TreeNode(m.getId(), m.getName(), m.getIcon())).collect(toList());
    }

    @Override
    public List<TreeNode> listTree(Integer roleId) {
        List<TreeNode> trees = Lists.newArrayList();
        List<Menu> menus = this.authMapper.listMenuByRoleId(roleId);
        menus.stream().filter(m -> m.getPaterId() == null).forEach(m -> {
            List<TreeNode> tree = createTree(menus, m.getId());
            if (CollectionUtils.isNotEmpty(tree)) {
                trees.add(new TreeNode(m.getId(), m.getName(), m.getIcon(), tree));
            }
        });
        return trees;
    }

    @Override
    public List<PermissionDto> listPermissions() {
        List<PermissionDto> list = operateMapper.listPermissions();
        // 根目录
        List<PermissionDto> trees = list.stream().filter(m1 -> m1.getPaterId() == null).collect(toList());
        trees.forEach(m2 -> {
            List<PermissionDto> permissions = list.stream()
                    .filter(p1 -> StringUtils.equals(p1.getOp(), "list") && Objects.equals(p1.getPaterId(), m2.getMenuId()))
                    .collect(toList());
            permissions.forEach(m3 -> {
                m3.setChildren(list.stream()
                        .filter(b1 -> !StringUtils.equals(b1.getOp(), "list") && Objects.equals(b1.getMenuId(), m3.getMenuId()))
                        .collect(toList()));
            });
            m2.setChildren(permissions);
        });
        return trees;
    }

    @Override
    public PageInfo<Menu> listMenuForDataGrid(DataGrid grid) {
        return PageHelper.startPage(grid.getPageNum(), grid.getPageSize()).doSelectPageInfo(this.menuMapper::listMenu);
    }

    @Override
    public List<Menu> listMenu() {
        List<Menu> menus = this.menuMapper.listMenu();
        menus.forEach(m -> m.setName(m.getPaterId() == null ? "－－" + m.getName() : "－－－－" + m.getName()));
        return menus;
    }

    @Override
    public void saveOrUpdate(Menu menu) {
        menu.setGmtModified(new Date());
        if (menu.getId() != null) {
            super.updateSelectiveById(menu);
        } else {
            super.insertSelective(menu);
        }
        this.menuMapper.refreshTreeNodes();
    }

}
