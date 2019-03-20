package com.huangxin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IGoodsDao;
import com.huangxin.entity.Goods;

public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {
	
	
	
	@Override
	public DetachedCriteria getDetachedCriteria(Goods goods1, Goods goods2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
		if (goods1 != null) {
			if (null != goods1.getName() && !"".equals(goods1.getName())) {
				dc.add(Restrictions.like("name", "%" + goods1.getName() + "%"));
			}

			if (null != goods1.getOrigin() && !"".equals(goods1.getOrigin())) {
				dc.add(Restrictions.like("origin", "%" + goods1.getOrigin() + "%"));
			}

			if (null != goods1.getProducer() && !"".equals(goods1.getProducer())) {
				dc.add(Restrictions.like("producer", "%" + goods1.getProducer() + "%"));
			}

			if (null != goods1.getUnit() && !"".equals(goods1.getUnit())) {
				dc.add(Restrictions.like("unit", "%" + goods1.getUnit() + "%"));
			}

			if (null != goods1.getInprice()&& !"".equals(goods1.getInprice())) {
				dc.add(Restrictions.ge("inprice",goods1.getInprice()));
			}

			if (null != goods1.getOutprice()&& !"".equals(goods1.getOutprice())) {
				dc.add(Restrictions.ge("outprice", goods1.getOutprice()));
			}

			if (null != goods1.getGoodstype()) {
				if (goods1.getGoodstype().getUuid()!=null) {
					dc.add(Restrictions.eq("goodstype", goods1.getGoodstype()));
				}
			}
		}
		if (goods2!=null) {
			if (null != goods2.getInprice()&& !"".equals(goods2.getInprice())) {
				dc.add(Restrictions.le("inprice",goods2.getInprice() ));
			}

			if (null != goods2.getOutprice()&& !"".equals(goods2.getOutprice())) {
				dc.add(Restrictions.le("outprice", goods2.getOutprice()));
			}
		}
		return dc;
	}
}
