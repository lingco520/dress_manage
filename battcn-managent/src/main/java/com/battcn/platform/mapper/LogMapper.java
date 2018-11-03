package com.battcn.platform.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.battcn.framework.mybatis.mapper.BaseMapper;
import com.battcn.platform.pojo.po.Log;

/**
 * @author Levin
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {
	
}