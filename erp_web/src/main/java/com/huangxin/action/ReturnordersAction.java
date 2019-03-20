package com.huangxin .action;

import com.huangxin .biz.IReturnordersBiz;
import com.huangxin .entity.Returnorders;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class ReturnordersAction extends BaseAction<Returnorders>{
	private IReturnordersBiz returnordersBiz;

	public void setReturnordersBiz(IReturnordersBiz returnordersBiz) {
		this.returnordersBiz = returnordersBiz;
		super.setBaseBiz(returnordersBiz);
	}
}
