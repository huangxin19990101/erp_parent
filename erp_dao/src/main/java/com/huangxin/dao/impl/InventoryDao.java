package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IInventoryDao;
import com.huangxin.entity.Inventory;

public class InventoryDao extends BaseDao<Inventory> implements IInventoryDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Inventory inventory1,Inventory inventory2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Inventory.class);
			if(inventory1!=null){
				if(null !=inventory1.getGoodsuuid() && !"".equals(inventory1.getGoodsuuid())) {
	dc.add(Restrictions.like("goodsuuid","%"+inventory1.getGoodsuuid()+"%"));
}

if(null !=inventory1.getStoreuuid() && !"".equals(inventory1.getStoreuuid())) {
	dc.add(Restrictions.like("storeuuid","%"+inventory1.getStoreuuid()+"%"));
}

if(null !=inventory1.getNum() && !"".equals(inventory1.getNum())) {
	dc.add(Restrictions.like("num","%"+inventory1.getNum()+"%"));
}

if(null !=inventory1.getType() && !"".equals(inventory1.getType())) {
	dc.add(Restrictions.like("type","%"+inventory1.getType()+"%"));
}

if(null !=inventory1.getCreatetime() && !"".equals(inventory1.getCreatetime())) {
	dc.add(Restrictions.like("createtime","%"+inventory1.getCreatetime()+"%"));
}

if(null !=inventory1.getChecktime() && !"".equals(inventory1.getChecktime())) {
	dc.add(Restrictions.like("checktime","%"+inventory1.getChecktime()+"%"));
}

if(null !=inventory1.getCreater() && !"".equals(inventory1.getCreater())) {
	dc.add(Restrictions.like("creater","%"+inventory1.getCreater()+"%"));
}

if(null !=inventory1.getChecker() && !"".equals(inventory1.getChecker())) {
	dc.add(Restrictions.like("checker","%"+inventory1.getChecker()+"%"));
}

if(null !=inventory1.getState() && !"".equals(inventory1.getState())) {
	dc.add(Restrictions.like("state","%"+inventory1.getState()+"%"));
}

if(null !=inventory1.getRemark() && !"".equals(inventory1.getRemark())) {
	dc.add(Restrictions.like("remark","%"+inventory1.getRemark()+"%"));
}


			}
				
		return dc;
	}
}
