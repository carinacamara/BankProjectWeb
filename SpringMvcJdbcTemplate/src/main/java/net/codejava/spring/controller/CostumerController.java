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

import net.codejava.spring.dao.CostumerDAO;
import net.codejava.spring.model.Costumer;

@Controller
public class CostumerController {
	
	@Autowired
	private CostumerDAO costumerDAO;
	
	@RequestMapping(value="/homeEmployee")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Costumer> listCostumer = costumerDAO.list();
		model.addObject("listCostumer", listCostumer);
		model.setViewName("homeEmployee");
		
		return model;
	}
	
	@RequestMapping(value = "/newCostumer", method = RequestMethod.GET)
	public ModelAndView newCostumer(ModelAndView model) {
		Costumer newCostumer = new Costumer();	
		model.addObject("costumer", newCostumer);
		model.setViewName("CostumerForm");
		return model;
	}
	
	@RequestMapping(value = "/saveCostumer", method = RequestMethod.POST)
	public ModelAndView saveCostumer(ModelAndView model,@Valid @ModelAttribute("costumer") Costumer costumer, BindingResult result) {
		if(result.hasErrors()) {
			model.setViewName("CostumerForm");
			return model;
		}
		costumerDAO.saveOrUpdate(costumer);	
		model.setViewName("redirect:/homeEmployee");
		return model;
	}
	
	@RequestMapping(value = "/deleteCostumer", method = RequestMethod.GET)
	public ModelAndView deleteCostumer(HttpServletRequest request) {
		int costumerId = Integer.parseInt(request.getParameter("id"));
		costumerDAO.delete(costumerId);
		return new ModelAndView("redirect:/homeEmployee");
	}
	
	@RequestMapping(value = "/editCostumer", method = RequestMethod.GET)
	public ModelAndView editCostumer(HttpServletRequest request) {
		int costumerId = Integer.parseInt(request.getParameter("id"));
		Costumer costumer = costumerDAO.get(costumerId);
		ModelAndView model = new ModelAndView("CostumerForm");
		model.addObject("costumer", costumer);
		
		return model;
	}

}
