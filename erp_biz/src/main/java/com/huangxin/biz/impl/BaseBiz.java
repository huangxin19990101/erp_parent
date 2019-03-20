package com.huangxin.biz.impl;

import java.util.List;

import com.huangxin.biz.IBaseBiz;
import com.huangxin.dao.IBaseDao;

public class BaseBiz<T> implements IBaseBiz<T>  {
	private IBaseDao baseDao;

	public void setTBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<T> getList(T t1,T t2,Object parma) {
		return baseDao.getList(t1,t2,parma);
	}
	/**
	 * 条件查询
	 */
	@Override
	public List<T> getList(T t1,T t2,Object parma,int firstResult,int maxResult) {
		return baseDao.getList(t1,t2,parma,firstResult,maxResult);
		
	}
	/**
	 * 条件查询的总条数
	 */
	@Override
	public Long getCount(T t1,T t2,Object parma) {
		return baseDao.getCount(t1,t2,parma);
	}
	/**
	 * 保存部门
	 */
	@Override
	public void add(T t) {
		baseDao.add(t);
	}
	/**
	 * 删除部门
	 */
	@Override
	public void delete(long uuid) {
		baseDao.delete(uuid);
	}
	/**
	 * 根据id查询部门
	 */
	@Override
	public T get(long uuid) {
		return (T) baseDao.get(uuid);
	}
	@Override
	public T get(String uuid) {
		return (T) baseDao.get(uuid);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}
	
}
