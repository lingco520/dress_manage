package com.battcn.platform.service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.BaseService;
import com.battcn.platform.pojo.po.Log;
import com.github.pagehelper.PageInfo;

/**
 * @author Levin
 */
public interface LogService extends BaseService<Log> {

    PageInfo<Log> listForDataGrid(DataGrid grid, String datetime);

}
