package net.codejava.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.EmployeeDAO;
import net.codejava.spring.dao.LoginDAO;
import net.codejava.spring.dao.TransactionDAO;
import net.codejava.spring.model.Employee;
import net.codejava.spring.model.Login;
import net.codejava.spring.model.Transaction;

@Controller
public class TransactionController {

	@Autowired
	private TransactionDAO transactionDAO;
	
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/listTransaction")
	public ModelAndView listTransaction(ModelAndView model) throws IOException{
		List<Transaction> listTransaction = transactionDAO.list();
		model.addObject("listTransaction", listTransaction);
		model.setViewName("listTransaction");
		
		return model;
	}
	
	@RequestMapping(value = "/newTransaction", method = RequestMethod.GET)
	public ModelAndView newTransaction(ModelAndView model) {
		
		Transaction newTransaction = new Transaction();
		newTransaction.setCurrentDate();
		
		Login login = loginDAO.getLast();
	
		String username = login.getUsername();
		String password =  login.getPassword();
		
		Employee employee = employeeDAO.getEmployee(username, password);
		
		int idStandard = employee.getId();
			
		
		model.addObject("idStandard", idStandard);
		
		model.addObject("transaction", newTransaction);
		model.setViewName("TransactionForm");
		
		return model;
	}
	
	@RequestMapping(value = "/saveTransaction", method = RequestMethod.POST)
	public ModelAndView saveTransaction(@ModelAttribute("transaction") @Valid Transaction transaction, ModelAndView model, BindingResult result) {
		
		if(result.hasErrors()){
			model.setViewName("TransactionForm");
			return model;
		}
			
		transactionDAO.saveOrUpdate(transaction);
		model.setViewName("redirect:/listTransaction");
		return model;
	}
	

	
	// pagina cu Raport Form unde cerem parametrii
	@RequestMapping(value = "/newRaport", method = RequestMethod.GET)
	public ModelAndView showRaportPage(ModelAndView model) throws IOException{
		
		model.setViewName("RaportForm");
		
		return model;
	}
		
	
	
	// pagina cu Listarea Raportului
	
	@RequestMapping(value="/listRaport")
	public ModelAndView listReport(ModelAndView model, @RequestParam Date creationDateOne, @RequestParam Date creationDateTwo, @RequestParam int idEmployee) throws IOException{
		
		model.addObject("creationDateOne",creationDateOne);
		model.addObject("creationDateTwo", creationDateTwo);
		model.addObject("idEmployee", idEmployee);
		
		
		List<Transaction> listRaport = transactionDAO.getRaport(creationDateOne,creationDateTwo, idEmployee);
		
		model.addObject("listRaport", listRaport);
		model.setViewName("listRaport");
		
		return model;
	}
	
	
	
	
	
}
