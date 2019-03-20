package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IGoodsBiz;
import com.huangxin.dao.IGoodsDao;
import com.huangxin.entity.Goods;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class GoodsBiz extends BaseBiz<Goods> implements IGoodsBiz {
	private IGoodsDao goodsDao;

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		super.setTBaseDao(goodsDao);
	}
}
