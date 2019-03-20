package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IStoreoperDao;
import com.huangxin.entity.Storeoper;

public class StoreoperDao extends BaseDao<Storeoper> implements IStoreoperDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Storeoper storeoper1,Storeoper storeoper2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Storeoper.class);
			if(storeoper1!=null){
				if(null !=storeoper1.getEmpuuid() && !"".equals(storeoper1.getEmpuuid())) {
	dc.add(Restrictions.like("empuuid","%"+storeoper1.getEmpuuid()+"%"));
}

if(null !=storeoper1.getOpertime() && !"".equals(storeoper1.getOpertime())) {
	dc.add(Restrictions.like("opertime","%"+storeoper1.getOpertime()+"%"));
}

if(null !=storeoper1.getStoreuuid() && !"".equals(storeoper1.getStoreuuid())) {
	dc.add(Restrictions.like("storeuuid","%"+storeoper1.getStoreuuid()+"%"));
}

if(null !=storeoper1.getGoodsuuid() && !"".equals(storeoper1.getGoodsuuid())) {
	dc.add(Restrictions.like("goodsuuid","%"+storeoper1.getGoodsuuid()+"%"));
}

if(null !=storeoper1.getNum() && !"".equals(storeoper1.getNum())) {
	dc.add(Restrictions.like("num","%"+storeoper1.getNum()+"%"));
}

if(null !=storeoper1.getType() && !"".equals(storeoper1.getType())) {
	dc.add(Restrictions.like("type","%"+storeoper1.getType()+"%"));
}


			}
				
		return dc;
	}
}
