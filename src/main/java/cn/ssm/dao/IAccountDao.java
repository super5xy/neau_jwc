package cn.ssm.dao;

import cn.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")
public interface IAccountDao {
//	查询所有账户信息
	@Select("select * from account")
	List<Account> findAll();
	//保存账户信息
	@Insert("insert into account (name,money) values(#{name},#{money})")
	void saveAccount (Account account);
	@Update("update account set name=#{name},money=#{money} where id=#{id}")
	void updateAccount (Account account);
	@Select("select * from account where name like \"%\"#{name}\"%\"")
	List<Account> findAccountByName (String name);
}
