package com.huangxin.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface IBaseDao<T> {
	List<T> getList(T t1,T t2,Object parma);
	/**
	 * 条件查询
	 * @param detachedCriteria
	 * @return
	 */
	List<T> getList(T t1,T t2,Object parma,int firstResult,int maxResult);
	
	/**
	 * 条件查询总条数
	 * @param t1
	 * @param t2
	 * @param parma
	 * @return
	 */
	Long getCount(T t1,T t2,Object parma);
	
	public void add(T t);
	
	void delete(long uuid);
	
	T get(long uuid);
	
	void update(T t);
	DetachedCriteria getDetachedCriteria(T t1,T t2,Object parma);
	T get(String uuid);
}
