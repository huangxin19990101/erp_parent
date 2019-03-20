package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IStoredetailBiz;
import com.huangxin.dao.IStoredetailDao;
import com.huangxin.entity.Storedetail;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class StoredetailBiz extends BaseBiz<Storedetail> implements IStoredetailBiz {
	private IStoredetailDao storedetailDao;

	public void setStoredetailDao(IStoredetailDao storedetailDao) {
		this.storedetailDao = storedetailDao;
		super.setTBaseDao(storedetailDao);
	}
}
