package com.huangxin .action;

import com.huangxin .biz.IOrderdetailBiz;
import com.huangxin .entity.Orderdetail;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class OrderdetailAction extends BaseAction<Orderdetail>{
	private IOrderdetailBiz orderdetailBiz;

	public void setOrderdetailBiz(IOrderdetailBiz orderdetailBiz) {
		this.orderdetailBiz = orderdetailBiz;
		super.setBaseBiz(orderdetailBiz);
	}
}
