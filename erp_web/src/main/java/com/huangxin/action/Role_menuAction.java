package com.huangxin .action;

import com.huangxin .biz.IRole_menuBiz;
import com.huangxin .entity.Role_menu;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class Role_menuAction extends BaseAction<Role_menu>{
	private IRole_menuBiz role_menuBiz;

	public void setRole_menuBiz(IRole_menuBiz role_menuBiz) {
		this.role_menuBiz = role_menuBiz;
		super.setBaseBiz(role_menuBiz);
	}
}
