package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IRole_menuBiz;
import com.huangxin.dao.IRole_menuDao;
import com.huangxin.entity.Role_menu;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class Role_menuBiz extends BaseBiz<Role_menu> implements IRole_menuBiz {
	private IRole_menuDao role_menuDao;

	public void setRole_menuDao(IRole_menuDao role_menuDao) {
		this.role_menuDao = role_menuDao;
		super.setTBaseDao(role_menuDao);
	}
}
