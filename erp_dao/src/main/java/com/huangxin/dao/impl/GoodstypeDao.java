package com.huangxin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IGoodstypeDao;
import com.huangxin.entity.Goods;
import com.huangxin.entity.Goodstype;

public class GoodstypeDao extends BaseDao<Goodstype> implements IGoodstypeDao {
	@Override
	public DetachedCriteria getDetachedCriteria(Goodstype goodstype1, Goodstype goodstype2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Goodstype.class);
		if (goodstype1 != null) {
			if (null != goodstype1.getName() && !"".equals(goodstype1.getName())) {
				dc.add(Restrictions.like("name", "%" + goodstype1.getName() + "%"));
			}

		}

		return dc;
	}
	
}
