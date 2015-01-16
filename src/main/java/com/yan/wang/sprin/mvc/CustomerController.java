package com.yan.wang.sprin.mvc;

import com.yan.wang.sprin.mvc.dao.Customer;
import com.yan.wang.sprin.mvc.dao.CustomerVoucher;
import com.yan.wang.sprin.mvc.dao.Voucher;
import com.yan.wang.sprin.mvc.dao.VoucherToReturn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/add")
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Add Page !");
		return "hello";
	}

	@RequestMapping(value = "{thing}" , method = RequestMethod.GET)
	public String showCustomerForm(@PathVariable String thing, Model model) {

		//modelMap.addAttribute("message", "Add customer !");
		//modelMap.put("customerForm", new Customer());
		model.addAttribute("message", "Add customer !");
		model.addAttribute("customerForm", new Customer());


		if (thing.equals("customer")) {
			return "addCustomer";
			//return new ModelAndView("addCustomer", "command", new Customer());
		} else {
			return "hello";
			//return new ModelAndView("hello", "command", new Customer());
		}



	}

	@RequestMapping(value = "{thing}" , method = RequestMethod.GET)
	public String showCustomerForm(@PathVariable String thing, @ModelAttribute("customerForm") Customer customer, Model model) {

		//modelMap.addAttribute("message", "Add customer !");
		//modelMap.put("customerForm", new Customer());
		model.addAttribute("message", "Customer Added !");
		model.addAttribute("customerForm", customer);


		if (thing.equals("customer")) {
			return "addCustomer";
			//return new ModelAndView("addCustomer", "command", new Customer());
		} else {
			return "hello";
			//return new ModelAndView("hello", "command", new Customer());
		}



	}
}