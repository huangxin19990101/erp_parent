package com.huangxin .action;

import com.huangxin .biz.IEmpBiz;
import com.huangxin .entity.Emp;
import com.opensymphony.xwork2.ActionContext;

/**
 * 部门action
 * 
 * @author Kay
 *
 */
public class EmpAction extends BaseAction<Emp>{
	private IEmpBiz empBiz;

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
		super.setBaseBiz(empBiz);
	}
	
	private String oldPwd;//旧密码
	private String newPwd;//新密码
	
	

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	/**
	 * 修改密码
	 */
	public void updatePwd(){
		Emp emp = this.getLoginUser();
		if (emp==null) {
			ajaxReturn(false, "您还没有登陆，请先登陆");
			return;
		}
		try {
			empBiz.updatePwd(emp.getUuid(), oldPwd, newPwd);
			ajaxReturn(true, "修改密码成功");
		} catch (Exception e) {
			ajaxReturn(false, "修改密码失败");
		}
		
	}
	/**
	 * 重置密码
	 */
	public void updatePwd_reset(){
		try {
			empBiz.updatePwd_reset(super.getId(), newPwd);
			ajaxReturn(true, "修改密码成功");
		} catch (Exception e) {
			ajaxReturn(false, "修改密码失败");
		}
	}


	public String getOldPwd() {
		return oldPwd;
	}


	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}


	public String getNewPwd() {
		return newPwd;
	}

}
