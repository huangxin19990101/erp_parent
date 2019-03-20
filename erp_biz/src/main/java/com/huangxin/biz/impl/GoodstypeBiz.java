package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IGoodstypeBiz;
import com.huangxin.dao.IGoodstypeDao;
import com.huangxin.entity.Goodstype;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class GoodstypeBiz extends BaseBiz<Goodstype> implements IGoodstypeBiz {
	private IGoodstypeDao goodstypeDao;

	public void setGoodstypeDao(IGoodstypeDao goodstypeDao) {
		this.goodstypeDao = goodstypeDao;
		super.setTBaseDao(goodstypeDao);
	}
	
	
}
