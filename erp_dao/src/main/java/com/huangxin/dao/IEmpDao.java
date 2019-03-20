package com.huangxin.dao;



import com.huangxin.entity.Emp;

public interface IEmpDao  extends IBaseDao<Emp>{
		Emp findByUsernameAndPwd(String username,String pwd);
		
		void updatePwd(Long uuid,String newPwd);
		
}
