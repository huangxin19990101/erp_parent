package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IMenuBiz;
import com.huangxin.dao.IMenuDao;
import com.huangxin.entity.Menu;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class MenuBiz extends BaseBiz<Menu> implements IMenuBiz {
	private IMenuDao menuDao;

	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
		super.setTBaseDao(menuDao);
	}
}
