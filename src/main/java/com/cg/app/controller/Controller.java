package com.cg.app.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.service.SavingsAccountService;
import com.cg.app.exception.AccountNotFoundException;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private SavingsAccountService service;
	
	@RequestMapping("/getAll")
	public String getAllSavingsAccounts(Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> accounts =service.getAllSavingsAccount();
		model.addAttribute("accounts", accounts);
		System.out.println(accounts);
		return "AccountDetails";
	}
	
	@RequestMapping("/searchForUpdate")
	public String updateForm() {
		return "searchForUpdate";
	}
	
	@RequestMapping("/updateForm")
	public String getUpdateForm(HttpServletRequest request, Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		int accountNumber =Integer.parseInt(request.getParameter("accountNumber"));
		SavingsAccount account=service.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "UpdateForm";
	}
}
