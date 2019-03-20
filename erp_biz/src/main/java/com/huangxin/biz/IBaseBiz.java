package com.huangxin.biz;

import java.util.List;


public interface IBaseBiz <T> {
	/**
	 * 查询所有
	 */
	List<T> getList(T t1,T t2,Object parma);
	/**
	 * 条件查询
	 * 
	 */
	List<T> getList(T t1,T t2,Object parma,int  firstResult,int maxResult);
	/**
	 * 查询总条数
	 */
	Long getCount(T t1,T t2,Object parma);
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t);
	/**
	 * 删除
	 * @param uuid
	 */
	void delete(long uuid);
	/**
	 * 根据id查询实体
	 */
	T get(long uuid);
	/**
	 * 更新
	 * @param t
	 */
	void update(T t);
	T get(String uuid);
}
