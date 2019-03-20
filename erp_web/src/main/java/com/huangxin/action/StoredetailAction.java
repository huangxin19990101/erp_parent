package com.huangxin .action;

import com.huangxin .biz.IStoredetailBiz;
import com.huangxin .entity.Storedetail;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class StoredetailAction extends BaseAction<Storedetail>{
	private IStoredetailBiz storedetailBiz;

	public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
		this.storedetailBiz = storedetailBiz;
		super.setBaseBiz(storedetailBiz);
	}
}
