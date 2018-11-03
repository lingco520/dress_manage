package com.battcn.platform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Menu;

/**
 * @author Levin
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询所有菜单,根据 scort 升序排序
     *
     * @return 查询结果
     */
    @Select("SELECT * FROM t_sys_menu WHERE locked = 1 ORDER BY scort ASC")
    List<Menu> listMenu();

    /**
     * 调用 refreshTreeNodes 存储过程
     */
    @Select("CALL refreshTreeNodes();")
    void refreshTreeNodes();


}