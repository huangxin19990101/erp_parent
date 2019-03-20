package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IRole_menuDao;
import com.huangxin.entity.Role_menu;

public class Role_menuDao extends BaseDao<Role_menu> implements IRole_menuDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Role_menu role_menu1,Role_menu role_menu2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Role_menu.class);
			if(role_menu1!=null){
				if(null !=role_menu1.getRoleuuid() && !"".equals(role_menu1.getRoleuuid())) {
	dc.add(Restrictions.like("roleuuid","%"+role_menu1.getRoleuuid()+"%"));
}

if(null !=role_menu1.getMenuuuid() && !"".equals(role_menu1.getMenuuuid())) {
	dc.add(Restrictions.like("menuuuid","%"+role_menu1.getMenuuuid()+"%"));
}


			}
				
		return dc;
	}
}
