package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.dto.RoleOperateDto;
import com.battcn.platform.pojo.po.Role;

/**
 * @author Levin
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {


    /**
     * 根据角色ID查询角色操作项
     *
     * @param roleId 角色ID
     * @return 查询结果
     */
    List<RoleOperateDto> listRoleOperateById(@Param("roleId") Integer roleId);

}