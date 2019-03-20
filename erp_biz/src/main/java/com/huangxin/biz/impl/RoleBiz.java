package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IRoleBiz;
import com.huangxin.dao.IRoleDao;
import com.huangxin.entity.Role;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class RoleBiz extends BaseBiz<Role> implements IRoleBiz {
	private IRoleDao roleDao;

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
		super.setTBaseDao(roleDao);
	}
}
