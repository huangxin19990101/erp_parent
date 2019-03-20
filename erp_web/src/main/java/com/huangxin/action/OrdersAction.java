package com.huangxin.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.huangxin.biz.IOrdersBiz;
import com.huangxin.entity.Emp;
import com.huangxin.entity.Orderdetail;
import com.huangxin.entity.Orders;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class OrdersAction extends BaseAction<Orders> {
	private IOrdersBiz ordersBiz;

	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
		super.setBaseBiz(ordersBiz);
	}

	// 接收订单明细的字符串，数组形式的json字符串，里面的元素为每个订单明细
	private String json;

	/**
	 * 添加订单
	 */
	public void add() {
		// 获取操作的员工
		Emp loginUser = super.getLoginUser();
		if (null == loginUser) {
			ajaxReturn(false, "请先登陆");
			return;
		}
		try {
			Orders orders = super.getT();
			// 设置订单创建者
			orders.setCreater(loginUser.getUuid());
			// 设置订单明细
			List<Orderdetail> orderdetails = JSON.parseArray(json, Orderdetail.class);
			orders.setOrderdetails(orderdetails);
			// 添加订单
			ordersBiz.add(orders);
			ajaxReturn(true, "添加订单成功");
		} catch (Exception e) {
			ajaxReturn(false, "添加订单失败");
			e.printStackTrace();
		}
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
