package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.battcn.platform.pojo.po.Menu;

/**
 * @author Levin
 */
@Mapper
public interface AuthMapper {

    /**
     * 根据角色ID查询可操作的菜单
     *
     * @param roleId 角色ID
     * @return 查询结果
     */
    List<Menu> listMenuByRoleId(@Param("roleId") Integer roleId);
}
