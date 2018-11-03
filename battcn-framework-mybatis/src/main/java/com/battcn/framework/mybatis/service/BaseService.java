package com.battcn.framework.mybatis.service;

import java.util.List;
import java.util.Optional;

import com.battcn.framework.mybatis.page.DataGrid;
import com.github.pagehelper.PageInfo;

/**
 * 基础操作
 *
 * @param <T> 泛型
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface BaseService<T> {

    /**
     * 新增一个实体，方法的实现需保证：当返回true时，实体entity的id属性已被赋值。
     *
     * @param entity 操作对象
     * @return 操作结果
     */
    boolean insert(T entity);

    /**
     * Null字段使用数据库默认值
     *
     * @param entity 操作对象
     * @return 操作结果
     */
    boolean insertSelective(T entity);

    /**
     * 根据主键删除一个实体
     *
     * @param key 主键
     * @return 操作结果
     */
    boolean deleteById(Object key);

    /**
     * 根据主键字段进行查询
     *
     * @param key 主键
     * @return 操作结果
     */
    Optional<T> selectById(Object key);

    /**
     * 根据主键更新实体全部字段( 公共属性部分不必赋值，入库拦截前会自动将修改人 修改时间加上)
     *
     * @param entity 操作对象
     * @return 操作结果
     */
    boolean updateById(T entity);

    /**
     * 根据主键更新不为NUll的值
     *
     * @param entity 操作对象
     * @return 操作结果
     */
    boolean updateSelectiveById(T entity);

    /**
     * 查询所有数据
     *
     * @return 查询结果
     */
    List<T> listAll();

    /**
     * 分页查询
     *
     * @param grid 分页对象
     * @return 查询结果
     */
    PageInfo<T> listForDataGrid(DataGrid grid);

    /**
     * 带条件分页查询
     *
     * @param grid   分页对象
     * @param entity 条件对象
     * @return 查询结果
     */
    PageInfo<T> listForDataGrid(DataGrid grid, T entity);
}
