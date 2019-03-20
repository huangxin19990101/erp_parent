package com.huangxin .action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.huangxin.biz.IBaseBiz;
import com.huangxin.entity.Emp;
import com.opensymphony.xwork2.ActionContext;

public class BaseAction<T> {
	//业务层通用类
	private IBaseBiz baseBiz;
//	登录的用户
	private static final String  loginUser = "loginUser";
	
	public static void main(String[] args) {
	}
	
	public void setBaseBiz(IBaseBiz baseBiz) {
		this.baseBiz = baseBiz;
	}
	//搜索条件
	private T t1;
	private T t2;
	private Object parma;

	private int page;// 页码
	private int rows;// 每页记录数


	// 删除的id
	private Long id;

	

	public Long getId() {
		return id;
	}

	/**
	 * 删除部门
	 */
	public void delete() {
		try {
			baseBiz.delete(id);
			ajaxReturn(true, "删除成功");
		} catch (Exception e) {
			ajaxReturn(false, "删除失败");
			e.printStackTrace();
		}
	}

	/**
	 * 根据id查询部门
	 */
	public void get() {
		T t = (T) baseBiz.get(id);
		String jsonString = JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd");
		String mapData = mapData(jsonString,"t");
		write(mapData);
	}
	
	/**
	 * 更新部门
	 */
	public void update(){
		try {
			baseBiz.update(t);
			ajaxReturn(true, "更新成功");
		} catch (Exception e) {
			ajaxReturn(false, "更新失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 转换map
	 * 加上的前缀prefix
	 */
	public String mapData(String jsonString,String prefix){
		Map<String,Object> map =  JSON.parseObject(jsonString);
		//新的map
		Map<String,Object> dataMap =  new HashMap<String,Object>();
		//给key加上前缀
		for (String key:map.keySet()) {
			//判断value是否为对象转成的map
			if (map.get(key) instanceof Map) {
				Map<String,Object> m2 =  (Map<String, Object>) map.get(key);
				//拼接key值
				for (String key2  : m2.keySet()) {
					dataMap.put(prefix+"."+key+"."+key2,m2.get(key2));
				}
			}else{
				dataMap.put(prefix+"."+key, map.get(key));
			}
			
		}
		return JSON.toJSONString(dataMap);
	}
	

	/**
	 * 查询所有部门
	 * 
	 * @return
	 * @throws IOException
	 */
	public void list() {
		List<T> list = baseBiz.getList(t1,t2,parma);
		
		String jsonString = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		write(jsonString);
	}

	public void getList() {
		try {
			int firstResult = (page - 1) * rows;
			List<T> list = baseBiz.getList(t1, t2, parma, firstResult, rows);
			Map<String, Object> map = new HashMap<String, Object>();
			// 查询总数
			Long total = baseBiz.getCount(t1, t2, parma);
			map.put("total", total);
			map.put("rows", list);
			//DisableCircularReferenceDetect禁用循环引用保护
			String jsonString = JSON.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect);
			write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public T getT2() {
		return t2;
	}
	//添加和更新的对象
	private T t;


	/**
	 * 新增方法
	 */
	public void add() {
		try {
			baseBiz.add(t);
			ajaxReturn(true, "添加成功");
		} catch (Exception e) {
			ajaxReturn(false, "添加失败");
			e.printStackTrace();
		}
	}
	public void ajaxReturn(boolean success, String message) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("success", success);
		rtn.put("message", message);
		write(JSON.toJSONString(rtn));
	}
	//数据回显到客户端
	public  void write(String jsonString) {
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Emp getLoginUser(){
		return (Emp) ActionContext.getContext().getSession().get(loginUser);
	}
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public void setT2(T t2) {
		this.t2 = t2;
	}

	public void setParma(Object parma) {
		this.parma = parma;
	}

	public void setT1(T t1) {
		this.t1 = t1;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public T getT1() {
		return t1;
	}
	
}
