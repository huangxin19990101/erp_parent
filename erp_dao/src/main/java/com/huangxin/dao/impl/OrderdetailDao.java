package com.huangxin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IOrderdetailDao;
import com.huangxin.entity.Orderdetail;

public class OrderdetailDao extends BaseDao<Orderdetail> implements IOrderdetailDao {
	@Override
	public DetachedCriteria getDetachedCriteria(Orderdetail orderdetail1, Orderdetail orderdetail2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Orderdetail.class);
		if (orderdetail1 != null) {
			if (null != orderdetail1.getGoodsuuid() && !"".equals(orderdetail1.getGoodsuuid())) {
				dc.add(Restrictions.like("goodsuuid", "%" + orderdetail1.getGoodsuuid() + "%"));
			}

			if (null != orderdetail1.getGoodsname() && !"".equals(orderdetail1.getGoodsname())) {
				dc.add(Restrictions.like("goodsname", "%" + orderdetail1.getGoodsname() + "%"));
			}

			if (null != orderdetail1.getPrice() && !"".equals(orderdetail1.getPrice())) {
				dc.add(Restrictions.like("price", "%" + orderdetail1.getPrice() + "%"));
			}

			if (null != orderdetail1.getNum() && !"".equals(orderdetail1.getNum())) {
				dc.add(Restrictions.like("num", "%" + orderdetail1.getNum() + "%"));
			}

			if (null != orderdetail1.getMoney() && !"".equals(orderdetail1.getMoney())) {
				dc.add(Restrictions.like("money", "%" + orderdetail1.getMoney() + "%"));
			}

			if (null != orderdetail1.getEndtime() && !"".equals(orderdetail1.getEndtime())) {
				dc.add(Restrictions.like("endtime", "%" + orderdetail1.getEndtime() + "%"));
			}

			if (null != orderdetail1.getEnder() && !"".equals(orderdetail1.getEnder())) {
				dc.add(Restrictions.like("ender", "%" + orderdetail1.getEnder() + "%"));
			}

			if (null != orderdetail1.getStoreuuid() && !"".equals(orderdetail1.getStoreuuid())) {
				dc.add(Restrictions.like("storeuuid", "%" + orderdetail1.getStoreuuid() + "%"));
			}

			if (null != orderdetail1.getState() && !"".equals(orderdetail1.getState())) {
				dc.add(Restrictions.like("state", "%" + orderdetail1.getState() + "%"));
			}

			if (null != orderdetail1.getOrders()&& !"".equals(orderdetail1.getOrders())) {
				dc.add(Restrictions.eq("orders", orderdetail1.getOrders() ));
			}

		}

		return dc;
	}
}
