package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IEmp_roleBiz;
import com.huangxin.dao.IEmp_roleDao;
import com.huangxin.entity.Emp_role;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class Emp_roleBiz extends BaseBiz<Emp_role> implements IEmp_roleBiz {
	private IEmp_roleDao emp_roleDao;

	public void setEmp_roleDao(IEmp_roleDao emp_roleDao) {
		this.emp_roleDao = emp_roleDao;
		super.setTBaseDao(emp_roleDao);
	}
}
