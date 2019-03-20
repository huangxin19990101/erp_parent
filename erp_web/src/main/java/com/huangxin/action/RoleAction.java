package com.huangxin .action;

import com.huangxin .biz.IRoleBiz;
import com.huangxin .entity.Role;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class RoleAction extends BaseAction<Role>{
	private IRoleBiz roleBiz;

	public void setRoleBiz(IRoleBiz roleBiz) {
		this.roleBiz = roleBiz;
		super.setBaseBiz(roleBiz);
	}
}
