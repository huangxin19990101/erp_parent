package com.huangxin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.huangxin.dao.IMenuDao;
import com.huangxin.entity.Menu;

public class MenuDao extends BaseDao<Menu> implements IMenuDao {
	@Override
	public DetachedCriteria getDetachedCriteria(Menu menu1, Menu menu2, Object parma) {
		DetachedCriteria dc = DetachedCriteria.forClass(Menu.class);
		if (menu1 != null) {
			if (null != menu1.getMenuname() && !"".equals(menu1.getMenuname())) {
				dc.add(Restrictions.like("menuname", "%" + menu1.getMenuname() + "%"));
			}

			if (null != menu1.getIcon() && !"".equals(menu1.getIcon())) {
				dc.add(Restrictions.like("icon", "%" + menu1.getIcon() + "%"));
			}

			if (null != menu1.getUrl() && !"".equals(menu1.getUrl())) {
				dc.add(Restrictions.like("url", "%" + menu1.getUrl() + "%"));
			}

			if (null != menu1.getPid() && !"".equals(menu1.getPid())) {
				dc.add(Restrictions.like("pid", "%" + menu1.getPid() + "%"));
			}

		}

		return dc;
	}
}
