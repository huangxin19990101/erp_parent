package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IReturnordersBiz;
import com.huangxin.dao.IReturnordersDao;
import com.huangxin.entity.Returnorders;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class ReturnordersBiz extends BaseBiz<Returnorders> implements IReturnordersBiz {
	private IReturnordersDao returnordersDao;

	public void setReturnordersDao(IReturnordersDao returnordersDao) {
		this.returnordersDao = returnordersDao;
		super.setTBaseDao(returnordersDao);
	}
}
