package cn.ssm.test;

import cn.ssm.dao.IAccountDao;
import cn.ssm.domain.Account;
import cn.ssm.exception.MyException;
import cn.ssm.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestSSM {


	@Test
	public void testspring(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
		List<Account> all = accountService.findAll();
		System.out.println(all);

	}
	@Test
	public void testmybatis() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		List<Account> Accounts = sqlSession.selectList("findAll");
//		System.out.println(Accounts);
		Account account =new Account();
		account.setMoney(0D);
		account.setName("TPC1875");
		sqlSession.update("saveAccount",account);
		sqlSession.commit();

		sqlSession.close();
		is.close();

	}
	@Test
	public void testspringsave(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
	Account a =new Account();
	a.setMoney(12d);
	a.setName("撒部署");
		accountService.saveAccount(a);

	}
	@Test
	public void testspringupdate() throws MyException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
//	Account a =new Account();
//	a.setId(17);
//	a.setMoney(12d);
//	a.setName("update");
//		accountService.updateAccount(a);
//		IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
//		List<Account> 悦悦 = accountDao.findAccountByName("撒部署");
//		System.out.println(悦悦);

//		accountService.transfer("张三","李四",500d);


	}
	@Test
	public void testchar(){
		Character a ='男';
		Character b ='男';
		System.out.println(a.equals(b));
//基本类型用==判断，char其实就是ascii
	}
	@Test
	public void teststring(){
		String face ="qwe.sadd";
		String suffix = face.substring(face.lastIndexOf(".")+ 1);
		System.out.println(suffix);
		String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";

		System.out.println(sentence.indexOf('8')); //字符第一次出现的位置

		System.out.println(sentence.indexOf("超神")); //字符串第一次出现的位置

		System.out.println(sentence.lastIndexOf("了")); //字符串最后出现的位置

		System.out.println(sentence.indexOf(',',5)); //从位置5开始，出现的第一次,的位置

		System.out.println(sentence.contains("击杀")); //是否包含字符串"击杀"

		String sentence1 = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

		//截取从第3个开始的字符串 （基0）
		String subString1 = sentence1.substring(3);

		System.out.println(subString1);

	}
}
