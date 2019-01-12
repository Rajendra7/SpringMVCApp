package com.cg.app.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.service.SavingsAccountService;
import com.cg.app.exception.AccountNotFoundException;



@Controller
public class AccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;

	@RequestMapping("/newSA")
	public String createNewsavingsAccountForm() {
		return "CreateSavingsAccountForm";
	}

	@RequestMapping("/createAccount")
	public String createNewsavingsAccount(@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountBalance") double accountBalance, @RequestParam("salary") boolean salary) throws ClassNotFoundException, SQLException {
		savingsAccountService.createNewAccount(accountHolderName, accountBalance, salary);
		return "redirect:getAll";
	}

	@RequestMapping("/getAll")
	public String getAllSavingAccounts(Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> savingsAccounts = savingsAccountService.getAllSavingsAccount();
		model.addAttribute("accounts", savingsAccounts);
		return "AccountDetails";
	}

	@RequestMapping("/close")
	public String closeAccountForm() {
		return "CloseAccountForm";
	}

	@RequestMapping("/closeAccount")
	public String getAllSavingAccounts(@RequestParam("accountNumber") int accountNumber) throws ClassNotFoundException, SQLException {
		try {
			savingsAccountService.deleteAccount(accountNumber);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:getAll";
	}

	@RequestMapping("/withdraw")
	public String withdrawForm() {
		return "WithdrawForm";
	}

	@RequestMapping("/withdrawAmount")
	public String withdraw(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") double amount) throws ClassNotFoundException, SQLException {

		try {
			SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
			savingsAccountService.withdraw(savingsAccount, amount);
		} catch (AccountNotFoundException e) {

			e.printStackTrace();
		}
		return "redirect:getAll";

	}

	@RequestMapping("/deposit")
	public String depositForm() {
		return "DepositForm";
	}

	@RequestMapping("/depositAmount")
	public String deposit(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") double amount) throws ClassNotFoundException, SQLException {
		try {
			SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
			savingsAccountService.deposit(savingsAccount, amount);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:getAll";
	}

	@RequestMapping("/fundTansfer")
	public String fundTransfer() {
		return "FundTransferForm";
	}

	@RequestMapping("/transferFunds")
	public String transfer(@RequestParam("sender") int sender, @RequestParam("receiver") int receiver,
			@RequestParam("amount") double amount) throws ClassNotFoundException, SQLException {
		try {
			SavingsAccount senderAccount = savingsAccountService.getAccountById(sender);
			SavingsAccount receiverAccount = savingsAccountService.getAccountById(receiver);
			savingsAccountService.fundTransfer(senderAccount, receiverAccount, amount);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}

		return "redirect:getAll";
	}

	@RequestMapping("/currentBalanceForm")
	public String currentBalanceForm() {
		return "CurrentBalanceForm";
	}

	@RequestMapping("/currentBalance")
	public String currentBalance(@RequestParam("accountNumber") int accountNumber,Model model) throws ClassNotFoundException, SQLException {
		double balance;
		try {
			balance = savingsAccountService.checkBalance(accountNumber);
			model.addAttribute("balance", balance);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "DisplayBalance";
	}
	@RequestMapping("/searchIdForm")
	public String searchByIdForm() {
		return "DisplayAccountForm";
	}
	@RequestMapping("/searchId")
	public String searchById(@RequestParam("accountNumber") int accountNumber,Model model) throws ClassNotFoundException, SQLException {
		try {
			SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
			model.addAttribute("account",account);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "DisplayAccount";
	}
	@RequestMapping("/searchNameForm")
	public String searchByNameForm() {
		return "SearchByNameForm";
	}
	@RequestMapping("/searchName")
	public String searchByName(@RequestParam("accountHolderName") String accountHolderName,Model model) throws ClassNotFoundException, SQLException {
		try {
			List<SavingsAccount> accounts = (List<SavingsAccount>) savingsAccountService.getAccountByName(accountHolderName);
			model.addAttribute("accounts",accounts);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "DisplayByName";
	}
	@RequestMapping("/updateAccountForm")
	public String updateAccountForm() {
		return "UpdateAccountForm";
	}
	@RequestMapping("/update")
	public String update(@RequestParam("accountNumber") int accountNumber,Model model) throws ClassNotFoundException, SQLException {
		
		try {
			SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
			model.addAttribute("account", savingsAccount);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "Update";
	}
	@RequestMapping("/updateAccount")
	public String updateAccount(@RequestParam("accountNumber") int accountNumber,@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountBalance") double accountBalance, @RequestParam("salary") boolean salary) throws ClassNotFoundException, SQLException{
		
		try {
			SavingsAccount savingsAccount = savingsAccountService.getAccountById(accountNumber);
			savingsAccount.getBankAccount().setAccountHolderName(accountHolderName);
			savingsAccount.setSalary(salary);
			savingsAccountService.updateAccount(savingsAccount);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:getAll";
	}
}