package com.huangxin .action;

import com.huangxin .biz.IStoreBiz;
import com.huangxin .entity.Store;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class StoreAction extends BaseAction<Store>{
	private IStoreBiz storeBiz;

	public void setStoreBiz(IStoreBiz storeBiz) {
		this.storeBiz = storeBiz;
		super.setBaseBiz(storeBiz);
	}
}
