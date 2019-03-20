package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IStoreDao;
import com.huangxin.entity.Store;

public class StoreDao extends BaseDao<Store> implements IStoreDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Store store1,Store store2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Store.class);
			if(store1!=null){
				if(null !=store1.getName() && !"".equals(store1.getName())) {
	dc.add(Restrictions.like("name","%"+store1.getName()+"%"));
}

if(null !=store1.getEmpuuid() && !"".equals(store1.getEmpuuid())) {
	dc.add(Restrictions.like("empuuid","%"+store1.getEmpuuid()+"%"));
}


			}
				
		return dc;
	}
}
