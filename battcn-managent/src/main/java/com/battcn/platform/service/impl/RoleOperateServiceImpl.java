package com.battcn.platform.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.battcn.framework.mybatis.service.impl.BaseServiceImpl;
import com.battcn.platform.mapper.RoleOperateMapper;
import com.battcn.platform.pojo.message.ApiResult;
import com.battcn.platform.pojo.po.RoleOperate;
import com.battcn.platform.service.RoleOperateService;
import com.google.common.collect.Lists;

/**
 * @author Levin
 */
@Service
public class RoleOperateServiceImpl extends BaseServiceImpl<RoleOperate> implements RoleOperateService {

    private final RoleOperateMapper roleOperateMapper;

    @Autowired
    public RoleOperateServiceImpl(RoleOperateMapper roleOperateMapper) {
        this.roleOperateMapper = roleOperateMapper;
    }

    @Override
    public List<RoleOperate> listRoleOperateByRoleId(Integer roleId) {

        return this.roleOperateMapper.listRoleOperateByRoleId(roleId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult<String> batchInsertRoleOperate(Integer[] operateIds, Integer roleId) {
        this.roleOperateMapper.delete(new RoleOperate(roleId));
        List<RoleOperate> ops = Lists.newArrayList(operateIds).stream().map(id -> new RoleOperate(roleId, id)).collect(toList());
        int result = this.roleOperateMapper.batchInsertRoleOperate(ops);
        return ApiResult.getResponse(result > 0);
    }

}
