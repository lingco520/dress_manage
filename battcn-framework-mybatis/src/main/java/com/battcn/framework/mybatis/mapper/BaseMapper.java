package com.battcn.framework.mybatis.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * 封装了通用Mybatis的操作,针对Mysql的BaseMapper
 *
 * @param <T> 泛型
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper {
}
