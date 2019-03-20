package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IReturnordersDao;
import com.huangxin.entity.Returnorders;

public class ReturnordersDao extends BaseDao<Returnorders> implements IReturnordersDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Returnorders returnorders1,Returnorders returnorders2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Returnorders.class);
			if(returnorders1!=null){
				if(null !=returnorders1.getCreatetime() && !"".equals(returnorders1.getCreatetime())) {
	dc.add(Restrictions.like("createtime","%"+returnorders1.getCreatetime()+"%"));
}

if(null !=returnorders1.getChecktime() && !"".equals(returnorders1.getChecktime())) {
	dc.add(Restrictions.like("checktime","%"+returnorders1.getChecktime()+"%"));
}

if(null !=returnorders1.getEndtime() && !"".equals(returnorders1.getEndtime())) {
	dc.add(Restrictions.like("endtime","%"+returnorders1.getEndtime()+"%"));
}

if(null !=returnorders1.getType() && !"".equals(returnorders1.getType())) {
	dc.add(Restrictions.like("type","%"+returnorders1.getType()+"%"));
}

if(null !=returnorders1.getCreater() && !"".equals(returnorders1.getCreater())) {
	dc.add(Restrictions.like("creater","%"+returnorders1.getCreater()+"%"));
}

if(null !=returnorders1.getChecker() && !"".equals(returnorders1.getChecker())) {
	dc.add(Restrictions.like("checker","%"+returnorders1.getChecker()+"%"));
}

if(null !=returnorders1.getEnder() && !"".equals(returnorders1.getEnder())) {
	dc.add(Restrictions.like("ender","%"+returnorders1.getEnder()+"%"));
}

if(null !=returnorders1.getSupplieruuid() && !"".equals(returnorders1.getSupplieruuid())) {
	dc.add(Restrictions.like("supplieruuid","%"+returnorders1.getSupplieruuid()+"%"));
}

if(null !=returnorders1.getTotalmoney() && !"".equals(returnorders1.getTotalmoney())) {
	dc.add(Restrictions.like("totalmoney","%"+returnorders1.getTotalmoney()+"%"));
}

if(null !=returnorders1.getState() && !"".equals(returnorders1.getState())) {
	dc.add(Restrictions.like("state","%"+returnorders1.getState()+"%"));
}

if(null !=returnorders1.getWaybillsn() && !"".equals(returnorders1.getWaybillsn())) {
	dc.add(Restrictions.like("waybillsn","%"+returnorders1.getWaybillsn()+"%"));
}

if(null !=returnorders1.getOrdersuuid() && !"".equals(returnorders1.getOrdersuuid())) {
	dc.add(Restrictions.like("ordersuuid","%"+returnorders1.getOrdersuuid()+"%"));
}


			}
				
		return dc;
	}
}
