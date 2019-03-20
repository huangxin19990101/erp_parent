package com.huangxin .action;

import com.huangxin .biz.IStoreoperBiz;
import com.huangxin .entity.Storeoper;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class StoreoperAction extends BaseAction<Storeoper>{
	private IStoreoperBiz storeoperBiz;

	public void setStoreoperBiz(IStoreoperBiz storeoperBiz) {
		this.storeoperBiz = storeoperBiz;
		super.setBaseBiz(storeoperBiz);
	}
}
