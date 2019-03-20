package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IReturnorderdetailDao;
import com.huangxin.entity.Returnorderdetail;

public class ReturnorderdetailDao extends BaseDao<Returnorderdetail> implements IReturnorderdetailDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Returnorderdetail returnorderdetail1,Returnorderdetail returnorderdetail2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Returnorderdetail.class);
			if(returnorderdetail1!=null){
				if(null !=returnorderdetail1.getGoodsuuid() && !"".equals(returnorderdetail1.getGoodsuuid())) {
	dc.add(Restrictions.like("goodsuuid","%"+returnorderdetail1.getGoodsuuid()+"%"));
}

if(null !=returnorderdetail1.getGoodsname() && !"".equals(returnorderdetail1.getGoodsname())) {
	dc.add(Restrictions.like("goodsname","%"+returnorderdetail1.getGoodsname()+"%"));
}

if(null !=returnorderdetail1.getPrice() && !"".equals(returnorderdetail1.getPrice())) {
	dc.add(Restrictions.like("price","%"+returnorderdetail1.getPrice()+"%"));
}

if(null !=returnorderdetail1.getNum() && !"".equals(returnorderdetail1.getNum())) {
	dc.add(Restrictions.like("num","%"+returnorderdetail1.getNum()+"%"));
}

if(null !=returnorderdetail1.getMoney() && !"".equals(returnorderdetail1.getMoney())) {
	dc.add(Restrictions.like("money","%"+returnorderdetail1.getMoney()+"%"));
}

if(null !=returnorderdetail1.getEndtime() && !"".equals(returnorderdetail1.getEndtime())) {
	dc.add(Restrictions.like("endtime","%"+returnorderdetail1.getEndtime()+"%"));
}

if(null !=returnorderdetail1.getEnder() && !"".equals(returnorderdetail1.getEnder())) {
	dc.add(Restrictions.like("ender","%"+returnorderdetail1.getEnder()+"%"));
}

if(null !=returnorderdetail1.getStoreuuid() && !"".equals(returnorderdetail1.getStoreuuid())) {
	dc.add(Restrictions.like("storeuuid","%"+returnorderdetail1.getStoreuuid()+"%"));
}

if(null !=returnorderdetail1.getState() && !"".equals(returnorderdetail1.getState())) {
	dc.add(Restrictions.like("state","%"+returnorderdetail1.getState()+"%"));
}

if(null !=returnorderdetail1.getOrdersuuid() && !"".equals(returnorderdetail1.getOrdersuuid())) {
	dc.add(Restrictions.like("ordersuuid","%"+returnorderdetail1.getOrdersuuid()+"%"));
}


			}
				
		return dc;
	}
}
