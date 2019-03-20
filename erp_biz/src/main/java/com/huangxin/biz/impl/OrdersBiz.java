package com.huangxin.biz.impl;

import java.util.Date;
import java.util.List;

import com.huangxin.biz.IOrdersBiz;
import com.huangxin.dao.IOrdersDao;
import com.huangxin.entity.Orderdetail;
import com.huangxin.entity.Orders;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz {
	private IOrdersDao ordersDao;

	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
		super.setTBaseDao(ordersDao);
	}
	
	public void add(Orders orders){
//		设置订单状态
		orders.setState(Orders.STATE_CREATE);
//		订单类型
		orders.setType(Orders.TYPE_IN);
//		下单时间
		orders.setCreatetime(new Date());
//		合计金额
		double total = 0;
		for (Orderdetail orderdetail : orders.getOrderdetails()) {
//			累计金额
			total += orderdetail.getMoney();
//			明细的状态
			orderdetail.setState(Orderdetail.STATE_NOT_IN);
//			设置跟订单的关系
			orderdetail.setOrders(orders);
		}
//		设置订单总金额
		orders.setTotalmoney(total);
		
		ordersDao.add(orders);
	}
}
