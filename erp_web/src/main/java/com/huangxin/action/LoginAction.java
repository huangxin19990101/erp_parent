package com.huangxin.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.huangxin.biz.IEmpBiz;
import com.huangxin.biz.impl.EmpBiz;
import com.huangxin.entity.Emp;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private IEmpBiz empBiz;

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	private String username;
	private String pwd;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void checkUser() {
		try {
			// 查询是否存在
			Emp loginUser = empBiz.findByUsernameAndPwd(username, pwd);
			if (loginUser != null) {
				ActionContext.getContext().getSession().put("loginUser", loginUser);
				ajaxReturn(true, "登陆成功");
			} else {
				ajaxReturn(false, "用户名或密码不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "登陆失败");
		}
	}
	/**
	 * 显示登陆用户名
	 */
	public void showName(){
		//获取当前登陆的用户
		Emp loginUser = (Emp) ActionContext.getContext().getSession().get("loginUser");
		//判断session是否会超时
		if (loginUser!=null) {
			ajaxReturn(true, loginUser.getName());
		}else{
			ajaxReturn(false,"");
		}
	}
	
	/**
	 * 退出登陆
	 */
	public void loginOut(){
		ActionContext.getContext().getSession().remove("loginUser");
	}
	
	public void ajaxReturn(boolean success, String message) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("success", success);
		rtn.put("message", message);
		write(JSON.toJSONString(rtn));
	}

	// 数据回显到客户端
	private void write(String jsonString) {
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
