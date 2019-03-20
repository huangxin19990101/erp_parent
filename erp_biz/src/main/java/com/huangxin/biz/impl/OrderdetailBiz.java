package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IOrderdetailBiz;
import com.huangxin.dao.IOrderdetailDao;
import com.huangxin.entity.Orderdetail;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class OrderdetailBiz extends BaseBiz<Orderdetail> implements IOrderdetailBiz {
	private IOrderdetailDao orderdetailDao;

	public void setOrderdetailDao(IOrderdetailDao orderdetailDao) {
		this.orderdetailDao = orderdetailDao;
		super.setTBaseDao(orderdetailDao);
	}
}
