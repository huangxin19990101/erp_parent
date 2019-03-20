package com.huangxin.dao.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IEmpDao;
import com.huangxin.entity.Emp;

public class EmpDao extends BaseDao<Emp> implements IEmpDao {


	@Override
	public DetachedCriteria getDetachedCriteria(Emp emp1, Emp emp2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Emp.class);
		if (emp1 != null) {
			if (null != emp1.getUsername() && !"".equals(emp1.getUsername())) {
				dc.add(Restrictions.like("username", "%" + emp1.getUsername() + "%"));
			}

			if (null != emp1.getName() && !"".equals(emp1.getName())) {
				dc.add(Restrictions.like("name", "%" + emp1.getName() + "%"));
			}

			if (null != emp1.getGender() && !"".equals(emp1.getGender())) {
				dc.add(Restrictions.eq("gender", emp1.getGender()));
			}

			if (null != emp1.getEmail() && !"".equals(emp1.getEmail())) {
				dc.add(Restrictions.like("email", "%" + emp1.getEmail() + "%"));
			}

			if (null != emp1.getTele() && !"".equals(emp1.getTele())) {
				dc.add(Restrictions.like("tele", "%" + emp1.getTele() + "%"));
			}

			if (null != emp1.getAddress() && !"".equals(emp1.getAddress())) {
				dc.add(Restrictions.like("address", "%" + emp1.getAddress() + "%"));
			}

			if (null != emp1.getDep() && !"".equals(emp1.getDep().getUuid()) && emp1.getDep().getUuid() != null) {
				dc.add(Restrictions.eq("dep", emp1.getDep()));
			}
			// 起始日期
			if (null != emp1.getBirthday() && !"".equals(emp1.getBirthday())) {
				dc.add(Restrictions.ge("birthday", emp1.getBirthday()));
			}

		}

		if (emp2 != null) {
			// 终止日期
			if (null != emp2.getBirthday() && !"".equals(emp2.getBirthday())) {
				dc.add(Restrictions.le("birthday", emp2.getBirthday()));
			}
		}

		return dc;
	}

	

	/**
	 * 用户登录
	 */
	@Override
	public Emp findByUsernameAndPwd(String username, String pwd) {
		
		String hql = "from Emp where username=? and pwd = ?";

		List<Emp> list = (List<Emp>) this.getHibernateTemplate().find(hql, username, pwd);
		if (list.size() > 0) {
			// 正确则返回第一个元素
			return list.get(0);
		}
		return null;
	}

	

	
	/**
	 * 修改密码
	 */
	public void updatePwd(Long uuid,String newPwd){
		String hql = "update Emp set pwd = ? where uuid = ?";
		this.getHibernateTemplate().bulkUpdate(hql,newPwd,uuid);
	}
}
