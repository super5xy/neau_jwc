package cn.ssm.controller;

import cn.ssm.domain.Account;
import cn.ssm.exception.MyException;
import cn.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	IAccountService accountService;

	@RequestMapping("findAll")
	public String findAll(Model model) {
		List<Account> accounts = accountService.findAll();
		model.addAttribute("account",accounts);
		return "list";
	}

	@RequestMapping("save")
	public String save(Account account) {

		accountService.saveAccount(account);
		return "redirect:findAll";
	}
	@RequestMapping("transfer")
	public String transfer(String sourceName ,String targetName,Double money) throws MyException {

		accountService.transfer(sourceName,targetName,money);
		return "redirect:findAll";
	}

}
