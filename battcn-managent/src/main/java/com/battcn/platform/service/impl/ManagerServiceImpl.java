package com.battcn.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battcn.framework.mybatis.page.DataGrid;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.ManagerMapper;
import com.battcn.platform.pojo.dto.ManagerDto;
import com.battcn.platform.pojo.po.Manager;
import com.battcn.platform.service.ManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author Levin
 */
@Service
public class ManagerServiceImpl extends BaseServiceImpl<Manager> implements ManagerService {

	private final ManagerMapper managerMapper;

	@Autowired
	public ManagerServiceImpl(ManagerMapper managerMapper) {
		this.managerMapper = managerMapper;
	}

	@Override
	public PageInfo<ManagerDto> listManagerByName(DataGrid grid, String name,String account) {
		grid.getOrderBy();
		return PageHelper.startPage(grid.getPageNum(), grid.getPageSize())
				.doSelectPageInfo(() -> this.managerMapper.listManagerByName(name,account));
	}

	@Override
	public ManagerDto selectManagerByAccount(String account) {
		return this.managerMapper.selectManagerByAccount(account);
	}


}
