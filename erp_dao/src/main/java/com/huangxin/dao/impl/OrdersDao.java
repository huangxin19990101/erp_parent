package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IOrdersDao;
import com.huangxin.entity.Orders;

public class OrdersDao extends BaseDao<Orders> implements IOrdersDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Orders orders1,Orders orders2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Orders.class);
			if(orders1!=null){
				if(null !=orders1.getCreatetime() && !"".equals(orders1.getCreatetime())) {
	dc.add(Restrictions.like("createtime","%"+orders1.getCreatetime()+"%"));
}

if(null !=orders1.getChecktime() && !"".equals(orders1.getChecktime())) {
	dc.add(Restrictions.like("checktime","%"+orders1.getChecktime()+"%"));
}

if(null !=orders1.getStarttime() && !"".equals(orders1.getStarttime())) {
	dc.add(Restrictions.like("starttime","%"+orders1.getStarttime()+"%"));
}

if(null !=orders1.getEndtime() && !"".equals(orders1.getEndtime())) {
	dc.add(Restrictions.like("endtime","%"+orders1.getEndtime()+"%"));
}

if(null !=orders1.getType() && !"".equals(orders1.getType())) {
	dc.add(Restrictions.like("type","%"+orders1.getType()+"%"));
}

if(null !=orders1.getCreater() && !"".equals(orders1.getCreater())) {
	dc.add(Restrictions.like("creater","%"+orders1.getCreater()+"%"));
}

if(null !=orders1.getChecker() && !"".equals(orders1.getChecker())) {
	dc.add(Restrictions.like("checker","%"+orders1.getChecker()+"%"));
}

if(null !=orders1.getStarter() && !"".equals(orders1.getStarter())) {
	dc.add(Restrictions.like("starter","%"+orders1.getStarter()+"%"));
}

if(null !=orders1.getEnder() && !"".equals(orders1.getEnder())) {
	dc.add(Restrictions.like("ender","%"+orders1.getEnder()+"%"));
}

if(null !=orders1.getSupplieruuid() && !"".equals(orders1.getSupplieruuid())) {
	dc.add(Restrictions.like("supplieruuid","%"+orders1.getSupplieruuid()+"%"));
}

if(null !=orders1.getTotalmoney() && !"".equals(orders1.getTotalmoney())) {
	dc.add(Restrictions.like("totalmoney","%"+orders1.getTotalmoney()+"%"));
}

if(null !=orders1.getState() && !"".equals(orders1.getState())) {
	dc.add(Restrictions.like("state","%"+orders1.getState()+"%"));
}

if(null !=orders1.getWaybillsn() && !"".equals(orders1.getWaybillsn())) {
	dc.add(Restrictions.like("waybillsn","%"+orders1.getWaybillsn()+"%"));
}


			}
				
		return dc;
	}
}
