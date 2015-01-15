package com.yan.wang.sprin.mvc;

import com.yan.wang.sprin.mvc.dao.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/show")
public class ShowController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Show Page !");
		return "hello";
	}

	@RequestMapping(value = "{thing}" , method = RequestMethod.POST)
	public String showCustomerSubmit(@PathVariable String thing, Model model, @ModelAttribute("customerForm") Customer customer) {

		model.addAttribute("message", "Add customer !");

		System.out.print(customer.getCustomer_id());
		System.out.print(customer.getEmail());


		if (thing.equals("customer")) {
			return "hello";
			//return new ModelAndView("addCustomer", "command", new Customer());
		} else {
			return "hello";
			//return new ModelAndView("hello", "command", new Customer());
		}



	}
}