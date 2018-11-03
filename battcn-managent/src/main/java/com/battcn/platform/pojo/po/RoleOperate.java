package com.battcn.platform.pojo.po;

import javax.persistence.*;

import com.battcn.platform.pojo.RecordEntity;

/**
 * @author Levin
 */
@Table(name = "t_sys_role_operate")
public class RoleOperate extends RecordEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5504636135897681812L;

	/**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 操作表ID
     */
    @Id
    @Column(name = "operate_id")
    private Integer operateId;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取操作表ID
     *
     * @return operate_id - 操作表ID
     */
    public Integer getOperateId() {
        return operateId;
    }

    /**
     * 设置操作表ID
     *
     * @param operateId 操作表ID
     */
    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public RoleOperate(){}
    public RoleOperate(Integer roleId){
    	super();
		this.roleId = roleId;
    }
    public RoleOperate(Integer roleId, Integer operateId){
    	super();
		this.roleId = roleId;
		this.operateId = operateId;
    }

    
    
}