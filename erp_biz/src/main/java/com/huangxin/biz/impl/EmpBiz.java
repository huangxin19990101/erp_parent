package com.huangxin.biz.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import com.huangxin.biz.IEmpBiz;
import com.huangxin.dao.IEmpDao;
import com.huangxin.entity.Emp;
import com.huangxin.exception.ErpException;

/**
 * 部门业务实现类
 * 
 * @author Kay
 *
 */
public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz {
	private IEmpDao empDao;
	private int hashIterations = 2;

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
		super.setTBaseDao(empDao);
	}

	@Override
	public Emp findByUsernameAndPwd(String username, String pwd) {

		// 查询前加密密码
		pwd = encrypt(pwd, username);
		return empDao.findByUsernameAndPwd(username, pwd);
	}

	@Override
	public void updatePwd(Long uuid, String oldPwd, String newPwd) {
		//取出员工信息
		Emp emp = empDao.get(uuid);
		//加密旧密码进行对比
		String encrypt = encrypt(oldPwd, emp.getUsername());
		if (!encrypt.equals(emp.getPwd())) {
			//旧密码错误
			//自定义异常
			throw new ErpException("旧密码不正确");
		}else{
			newPwd = encrypt(newPwd, emp.getUsername());
			empDao.updatePwd(uuid, newPwd);
		}
	}

	/**
	 * 更新部门
	 */
	@Override
	public void update(Emp emp) {
		// 密码加密
//		emp.setPwd(encrypt(emp.getPwd(), emp.getUsername()));
		empDao.update(emp);
	}
	
	/**
	 * 重写新增方法，加密密码
	 */
	@Override
	public void add(Emp emp) {
		// 密码加密
//		设置默认密码
		emp.setPwd(encrypt(emp.getUsername(), emp.getUsername()));
		empDao.add(emp);
	}

	private String encrypt(String source, String salt) {
		// source:加密的源码,salt:搅乱码,hashIterations:散列次数：加密次数
		Md5Hash md5 = new Md5Hash(source, salt, hashIterations);
		// 取出加密后的密码
		return md5.toString();
	}
	/**
	 * 管理员重置密码
	 */
	@Override
	public void updatePwd_reset(Long uuid, String newPwd) {
		Emp emp = empDao.get(uuid);
		newPwd=encrypt(newPwd,emp.getUsername());
		empDao.updatePwd(uuid, newPwd);
	}
	
}
