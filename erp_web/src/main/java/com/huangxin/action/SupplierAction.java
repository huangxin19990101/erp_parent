package com.huangxin .action;

import com.huangxin .biz.ISupplierBiz;
import com.huangxin .entity.Supplier;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class SupplierAction extends BaseAction<Supplier>{
	private ISupplierBiz supplierBiz;

	public void setSupplierBiz(ISupplierBiz supplierBiz) {
		this.supplierBiz = supplierBiz;
		super.setBaseBiz(supplierBiz);
	}
}
