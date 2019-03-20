package com.huangxin .action;

import com.huangxin .biz.IInventoryBiz;
import com.huangxin .entity.Inventory;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class InventoryAction extends BaseAction<Inventory>{
	private IInventoryBiz inventoryBiz;

	public void setInventoryBiz(IInventoryBiz inventoryBiz) {
		this.inventoryBiz = inventoryBiz;
		super.setBaseBiz(inventoryBiz);
	}
}
