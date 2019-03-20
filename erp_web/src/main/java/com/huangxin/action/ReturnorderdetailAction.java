package com.huangxin .action;

import com.huangxin .biz.IReturnorderdetailBiz;
import com.huangxin .entity.Returnorderdetail;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class ReturnorderdetailAction extends BaseAction<Returnorderdetail>{
	private IReturnorderdetailBiz returnorderdetailBiz;

	public void setReturnorderdetailBiz(IReturnorderdetailBiz returnorderdetailBiz) {
		this.returnorderdetailBiz = returnorderdetailBiz;
		super.setBaseBiz(returnorderdetailBiz);
	}
}
