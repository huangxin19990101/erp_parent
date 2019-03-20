package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IStoredetailDao;
import com.huangxin.entity.Storedetail;

public class StoredetailDao extends BaseDao<Storedetail> implements IStoredetailDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Storedetail storedetail1,Storedetail storedetail2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Storedetail.class);
			if(storedetail1!=null){
				if(null !=storedetail1.getStoreuuid() && !"".equals(storedetail1.getStoreuuid())) {
	dc.add(Restrictions.like("storeuuid","%"+storedetail1.getStoreuuid()+"%"));
}

if(null !=storedetail1.getGoodsuuid() && !"".equals(storedetail1.getGoodsuuid())) {
	dc.add(Restrictions.like("goodsuuid","%"+storedetail1.getGoodsuuid()+"%"));
}

if(null !=storedetail1.getNum() && !"".equals(storedetail1.getNum())) {
	dc.add(Restrictions.like("num","%"+storedetail1.getNum()+"%"));
}


			}
				
		return dc;
	}
}
