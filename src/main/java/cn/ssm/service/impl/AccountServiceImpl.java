package cn.ssm.service.impl;

import cn.ssm.dao.IAccountDao;
import cn.ssm.domain.Account;
import cn.ssm.exception.MyException;
import cn.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	@Autowired
	IAccountDao accountDao;

	@Override
	public List<Account> findAll() {
		List<Account> accounts = accountDao.findAll();
		return accounts;

	}

	@Override
	public void saveAccount(Account account) {
		accountDao.saveAccount(account);
	}

	@Override
	public void transfer(String sourceName, String targetName, Double money) throws MyException {

		List<Account> sources = accountDao.findAccountByName(sourceName);
		List<Account> targets = accountDao.findAccountByName(targetName);
		if (sources.size()>1||targets.size()>1){
			throw new MyException("查询到姓名的结果不唯一，无法转账");
		}else {
			Account source =sources.get(0);
			Account target =targets.get(0);
			source.setMoney(source.getMoney()-money);
			target.setMoney(target.getMoney()+money);
			accountDao.updateAccount(source);
//			int i=1/0;
			accountDao.updateAccount(target);
		}
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}
}
