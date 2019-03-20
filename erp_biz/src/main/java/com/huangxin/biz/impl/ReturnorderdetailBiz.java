package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IReturnorderdetailBiz;
import com.huangxin.dao.IReturnorderdetailDao;
import com.huangxin.entity.Returnorderdetail;
/**
 * 部门业务实现类
 * @author Kay
 *
 */
public class ReturnorderdetailBiz extends BaseBiz<Returnorderdetail> implements IReturnorderdetailBiz {
	private IReturnorderdetailDao returnorderdetailDao;

	public void setReturnorderdetailDao(IReturnorderdetailDao returnorderdetailDao) {
		this.returnorderdetailDao = returnorderdetailDao;
		super.setTBaseDao(returnorderdetailDao);
	}
}
