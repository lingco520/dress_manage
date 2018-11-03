package com.battcn.framework.mybatis.template;

import java.util.List;


/**
 * 缺省全局通用数据访问对象，缺省数据访问对象连接到dataSource Bean配置的数据源
 *
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface MybatisSqlDao {

    /**
     * 保存对象
     *
     * @param statement 命名空间
     * @param record    保存对象
     * @return 操作结果
     */
    int save(String statement, Object record);

    /**
     * 批量保存
     *
     * @param statement 命名空间
     * @param records   保存对象
     * @return 操作结果
     * @throws Exception 异常
     */
    int batchSave(String statement, List<?> records) throws Exception;

    /**
     * 更新数据
     *
     * @param statement 命名空间
     * @param record    操作对象
     * @return 操作结果
     */
    int update(String statement, Object record);


    /**
     * 批量更新数据
     *
     * @param statement 命名空间
     * @param records   操作对象
     * @return 操作结果
     */
    void batchUpdate(String statement, List<?> records);


    /**
     * 删除数据
     *
     * @param statement 命名空间
     * @param record    操作对象
     * @return 操作结果
     */
    Object delete(String statement, Object record);


    /**
     * 查找对象
     *
     * @param statement 命名空间
     * @param record    操作对象
     * @return 操作结果
     */
    Object findForObject(String statement, Object record);

    /**
     * 查找对象
     *
     * @param statement 命名空间
     * @param record    操作对象
     * @return 操作结果
     */
    Object queryForList(String statement, Object record);

}
