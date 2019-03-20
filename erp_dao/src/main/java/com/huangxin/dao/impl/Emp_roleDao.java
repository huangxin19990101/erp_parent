package com.huangxin.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IEmp_roleDao;
import com.huangxin.entity.Emp_role;

public class Emp_roleDao extends BaseDao<Emp_role> implements IEmp_roleDao {
	@Override
	public  DetachedCriteria getDetachedCriteria(Emp_role emp_role1,Emp_role emp_role2,Object parma){
		DetachedCriteria dc = DetachedCriteria.forClass(Emp_role.class);
			if(emp_role1!=null){
				if(null !=emp_role1.getEmpuuid() && !"".equals(emp_role1.getEmpuuid())) {
	dc.add(Restrictions.like("empuuid","%"+emp_role1.getEmpuuid()+"%"));
}

if(null !=emp_role1.getRoleuuid() && !"".equals(emp_role1.getRoleuuid())) {
	dc.add(Restrictions.like("roleuuid","%"+emp_role1.getRoleuuid()+"%"));
}


			}
				
		return dc;
	}
}
