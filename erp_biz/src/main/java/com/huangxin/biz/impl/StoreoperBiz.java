package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IStoreoperBiz;
import com.huangxin.dao.IStoreoperDao;
import com.huangxin.entity.Storeoper;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class StoreoperBiz extends BaseBiz<Storeoper> implements IStoreoperBiz {
	private IStoreoperDao storeoperDao;

	public void setStoreoperDao(IStoreoperDao storeoperDao) {
		this.storeoperDao = storeoperDao;
		super.setTBaseDao(storeoperDao);
	}
}
