package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.AccountDAO;
import net.codejava.spring.model.Account;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/listAccount")
	public ModelAndView listAccount(ModelAndView model) throws IOException{
		List<Account> listAccount = accountDAO.list();
		model.addObject("listAccount", listAccount);
		model.setViewName("listAccount");
		
		return model;
	}
	
	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	public ModelAndView newAccount(ModelAndView model) {
		
		Account newAccount = new Account();
		newAccount.setCurrentDate();
		
		model.addObject("account", newAccount);
		model.setViewName("AccountForm");
		return model;
	}
	
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public ModelAndView saveAccount(@Valid @ModelAttribute("account") Account account, ModelAndView model, BindingResult result) {
		
	/*	if( account.getIdCostumer() == 0) {
			model.addObject("messageIdCostumer","Please enter an id!");
			model.setViewName("AccountForm");
		}
		*/
		
		
		if(result.hasErrors()){
			model.setViewName("AccountForm");
			return model;
		}
				accountDAO.saveOrUpdate(account);	
		model.setViewName("redirect:/listAccount");
		return model;
	}
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public ModelAndView deleteAccount(HttpServletRequest request) {
		int accountId = Integer.parseInt(request.getParameter("id"));
		accountDAO.delete(accountId);
		return new ModelAndView("redirect:/listAccount");
	}
	
	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editAccount(HttpServletRequest request) {
		int accountId = Integer.parseInt(request.getParameter("id"));
		Account account = accountDAO.get(accountId);
		ModelAndView model = new ModelAndView("AccountForm");
		model.addObject("account", account);
		
		return model;
	}

}
