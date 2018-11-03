package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.dto.ManagerDto;
import com.battcn.platform.pojo.po.Manager;

/**
 * @author Levin
 */
@Mapper
public interface ManagerMapper extends BaseMapper<Manager> {

    /**
     * 根据条件查询角色信息
     *
     * @param name    名称
     * @param account 账号
     * @return
     */
    List<ManagerDto> listManagerByName(@Param("name") String name, @Param("account") String account);

    /**
     * 根据账号查询角色信息
     *
     * @param account 账号
     * @return 角色信息
     */
    @Select("SELECT t1.*,t2.name roleName,t2.code roleCode FROM t_sys_manager t1 JOIN t_sys_role t2 ON t2.id = t1.role_id WHERE account = #{account}")
    ManagerDto selectManagerByAccount(@Param("account") String account);

}