package com.huangxin .action;

import com.huangxin .biz.IGoodsBiz;
import com.huangxin .entity.Goods;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class GoodsAction extends BaseAction<Goods>{
	private IGoodsBiz goodsBiz;

	public void setGoodsBiz(IGoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
		super.setBaseBiz(goodsBiz);
	}
}
