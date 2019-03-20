package com.huangxin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.ISupplierDao;
import com.huangxin.entity.Supplier;

public class SupplierDao extends BaseDao<Supplier> implements ISupplierDao {
	@Override
	public DetachedCriteria getDetachedCriteria(Supplier supplier1, Supplier supplier2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Supplier.class);
		if (supplier1 != null) {
			if (null != supplier1.getName() && !"".equals(supplier1.getName())) {
				dc.add(Restrictions.like("name", "%" + supplier1.getName() + "%"));
			}

			if (null != supplier1.getAddress() && !"".equals(supplier1.getAddress())) {
				dc.add(Restrictions.like("address", "%" + supplier1.getAddress() + "%"));
			}

			if (null != supplier1.getContact() && !"".equals(supplier1.getContact())) {
				dc.add(Restrictions.like("contact", "%" + supplier1.getContact() + "%"));
			}

			if (null != supplier1.getTele() && !"".equals(supplier1.getTele())) {
				dc.add(Restrictions.like("tele", "%" + supplier1.getTele() + "%"));
			}

			if (null != supplier1.getEmail() && !"".equals(supplier1.getEmail())) {
				dc.add(Restrictions.like("email", "%" + supplier1.getEmail() + "%"));
			}
			//根据类型查询
			if (null != supplier1.getType() && !"".equals(supplier1.getType())) {
				dc.add(Restrictions.eq("type", supplier1.getType()));
			}

		}

		return dc;
	}
}
