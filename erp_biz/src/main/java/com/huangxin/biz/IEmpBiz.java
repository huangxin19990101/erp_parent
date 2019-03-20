package com.huangxin.biz;

import java.util.List;

import com.huangxin.entity.Emp;

/**
 * 部门业务接口
 * @author Kay
 *
 */
public interface IEmpBiz extends IBaseBiz<Emp>{
	Emp findByUsernameAndPwd(String username,String pwd);
	void updatePwd(Long uuid,String oldPwd,String newPwd);
	void updatePwd_reset(Long uuid,String newPwd);
}
