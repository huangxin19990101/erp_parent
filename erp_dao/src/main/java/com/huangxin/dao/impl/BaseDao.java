package com.huangxin.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.huangxin.dao.IBaseDao;

public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> entityClass;
	public BaseDao(){
		//通过子类获取父类
		Type baseDao = this.getClass().getGenericSuperclass();
		//转成参数化类型
		ParameterizedType ptype= (ParameterizedType)baseDao;
		//获取实际参数类型
		Type[] types = ptype.getActualTypeArguments();
		//Class是Type接口的实现类
		entityClass = (Class<T>) types[0];
	}
	
	/**
	 * 查询所有的部门信息
	 */
	@Override
	public List<T> getList(T t1,T t2,Object parma) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2, parma);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<T> getList(T t1,T t2,Object parma,int firstResult,int maxResult) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2, parma);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc,firstResult,maxResult);
	}
	/**
	 * 计算条件查询的总记录数
	 */
	@Override
	public Long getCount(T t1,T t2,Object parma) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2, parma);
		dc.setProjection(Projections.rowCount());
		List<Long> list =(List<Long> ) this.getHibernateTemplate().findByCriteria(dc);
		if (list.size()>0) {
			return (long) list.get(0);
		}
		return null;
	}
	/**
	 * 由子类实现
	 */
	@Override
	public DetachedCriteria getDetachedCriteria(T t1,T t2,Object parma){
		
		return null;
	}

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}
	/**
	 * 删除部门
	 */
	@Override
	public void delete(long uuid) {
		T t = this.getHibernateTemplate().get(entityClass, uuid);
		this.getHibernateTemplate().delete(t);
	}
	/**
	 * 查询部门
	 */
	@Override
	public T get(String uuid) {
		return this.getHibernateTemplate().get(entityClass, uuid);
	}
	@Override
	public T get(long uuid) {
		return this.getHibernateTemplate().get(entityClass, uuid);
	}
	
	
	/**
	 * 更新部门
	 */
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

		
	
}
