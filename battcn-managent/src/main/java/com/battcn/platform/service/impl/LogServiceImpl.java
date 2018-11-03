package com.battcn.platform.service.impl;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.platform.mapper.LogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.pojo.po.Log;
import com.battcn.platform.service.LogService;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Levin
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

    private final LogMapper logMapper;

    @Autowired
    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Override
    public PageInfo<Log> listForDataGrid(DataGrid grid, String datetime) {
        Example example = new Example(Log.class);
        String startTime, endTime;
        if (StringUtils.isNotEmpty(datetime)) {
            String[] time = datetime.split(" - ");
            startTime = time[0];
            endTime = time[1];
            example.createCriteria().andBetween("gmtCreate", startTime, endTime);
        }
        return PageHelper.startPage(grid.getPageNum(), grid.getPageSize()).doSelectPageInfo(() -> this.logMapper.selectByExample(example));
    }
}
