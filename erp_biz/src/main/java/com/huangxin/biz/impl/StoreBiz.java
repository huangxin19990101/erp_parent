package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IStoreBiz;
import com.huangxin.dao.IStoreDao;
import com.huangxin.entity.Store;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class StoreBiz extends BaseBiz<Store> implements IStoreBiz {
	private IStoreDao storeDao;

	public void setStoreDao(IStoreDao storeDao) {
		this.storeDao = storeDao;
		super.setTBaseDao(storeDao);
	}
}
