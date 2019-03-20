package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.ISupplierBiz;
import com.huangxin.dao.ISupplierDao;
import com.huangxin.entity.Supplier;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class SupplierBiz extends BaseBiz<Supplier> implements ISupplierBiz {
	private ISupplierDao supplierDao;

	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		super.setTBaseDao(supplierDao);
	}
}
