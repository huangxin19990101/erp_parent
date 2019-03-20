package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IDepBiz;
import com.huangxin.dao.IDepDao;
import com.huangxin.entity.Dep;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class DepBiz extends BaseBiz<Dep> implements IDepBiz {
	private IDepDao depDao;

	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
		super.setTBaseDao(depDao);
	}
}
