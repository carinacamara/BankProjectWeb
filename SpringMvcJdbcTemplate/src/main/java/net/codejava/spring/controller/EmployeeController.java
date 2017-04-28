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

import net.codejava.spring.dao.EmployeeDAO;
import net.codejava.spring.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	// Aici afisam toti employee pe pagina destinata administratorului
	@RequestMapping(value="/homeAdmin")
	public ModelAndView listEmployee(ModelAndView model) throws IOException{
		List<Employee> listEmployee = employeeDAO.list();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("homeAdmin");
		
		return model;
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newemployee(ModelAndView model) {
		Employee newEmployee = new Employee();
		model.addObject("employee", newEmployee);
		model.setViewName("EmployeeForm");
		return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(ModelAndView model,@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if(result.hasErrors()){
			model.setViewName("EmployeeForm");
			return model;
		}
		
		employeeDAO.saveOrUpdate(employee);	
		model.setViewName("redirect:/homeAdmin");
		return model;
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeDAO.delete(employeeId);
		return new ModelAndView("redirect:/homeAdmin");
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.get(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);
		
		return model;
	}
}
