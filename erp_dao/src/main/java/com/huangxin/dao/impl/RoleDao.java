package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IRoleDao;
import com.huangxin.entity.Role;

public class RoleDao extends BaseDao<Role> implements IRoleDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Role role1,Role role2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Role.class);
			if(role1!=null){
				if(null !=role1.getName() && !"".equals(role1.getName())) {
	dc.add(Restrictions.like("name","%"+role1.getName()+"%"));
}


			}
				
		return dc;
	}
}
