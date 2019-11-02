package cn.ssm.service;

import cn.ssm.domain.Account;
import cn.ssm.exception.MyException;

import java.util.List;

public interface IAccountService {
	//	查询所有账户信息
	List<Account> findAll();
	//保存账户信息
	void saveAccount (Account account);

	void transfer(String sourceName,String targetName,Double money) throws MyException;
	void updateAccount (Account account);


}
