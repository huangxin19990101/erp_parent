package com.huangxin .action;

import com.huangxin .biz.IDepBiz;
import com.huangxin .entity.Dep;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class DepAction extends BaseAction<Dep>{
	private IDepBiz depBiz;

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
		super.setBaseBiz(depBiz);
	}
}
