package com.huangxin.entity;

import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 商品分类
 * 
 * @author Kay
 *
 */
public class Goodstype {
	public Set<Goods> getGoodss() {
		return goodss;
	}

	public void setGoodss(Set<Goods> goodss) {
		this.goodss = goodss;
	}

	private Long uuid;// 商品类型编号
	private String name;// 商品类型名称
	@JSONField(serialize=false)
	private Set<Goods> goodss;
	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
