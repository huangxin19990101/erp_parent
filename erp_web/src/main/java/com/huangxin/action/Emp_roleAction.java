package com.huangxin .action;

import com.huangxin .biz.IEmp_roleBiz;
import com.huangxin .entity.Emp_role;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class Emp_roleAction extends BaseAction<Emp_role>{
	private IEmp_roleBiz emp_roleBiz;

	public void setEmp_roleBiz(IEmp_roleBiz emp_roleBiz) {
		this.emp_roleBiz = emp_roleBiz;
		super.setBaseBiz(emp_roleBiz);
	}
}
