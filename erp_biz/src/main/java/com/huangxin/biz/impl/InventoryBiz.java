package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IInventoryBiz;
import com.huangxin.dao.IInventoryDao;
import com.huangxin.entity.Inventory;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class InventoryBiz extends BaseBiz<Inventory> implements IInventoryBiz {
	private IInventoryDao inventoryDao;

	public void setInventoryDao(IInventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
		super.setTBaseDao(inventoryDao);
	}
}
