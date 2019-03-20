package com.huangxin .action;

import com.alibaba.fastjson.JSON;
import com.huangxin .biz.IMenuBiz;
import com.huangxin .entity.Menu;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class MenuAction extends BaseAction<Menu>{
	private IMenuBiz menuBiz;

	public void setMenuBiz(IMenuBiz menuBiz) {
		this.menuBiz = menuBiz;
		super.setBaseBiz(menuBiz);
	}
	/**
	 * 获取菜单数据
	 */
	public void getMeneTrees(){
		//通过获取主菜单,自关联就会带出所有子菜单
		Menu menu = menuBiz.get("0");
		write(JSON.toJSONString(menu));
	}
	/*
	private String  id;

	

	public void setId(String id) {
		this.id = id;
	}*/
}
