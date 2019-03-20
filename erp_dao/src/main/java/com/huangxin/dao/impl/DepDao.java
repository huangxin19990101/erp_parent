package com.huangxin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IDepDao;
import com.huangxin.entity.Dep;

public class DepDao extends BaseDao<Dep> implements IDepDao {
	@Override
	public DetachedCriteria getDetachedCriteria(Dep dep1, Dep dep2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Dep.class);
		if (dep1 != null) {
			if (null != dep1.getName() && !"".equals(dep1.getName())) {
				dc.add(Restrictions.like("name", "%" + dep1.getName() + "%"));
			}

			if (null != dep1.getTele() && !"".equals(dep1.getTele())) {
				dc.add(Restrictions.like("tele", "%" + dep1.getTele() + "%"));
			}

		}

		return dc;
	}
}
