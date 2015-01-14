package com.yan.wang.sprin.mvc;

import com.yan.wang.sprin.mvc.dao.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value = "page1", method = RequestMethod.GET)
	public String page1(ModelMap model) {
		model.addAttribute("message", "DB Status");

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver" );
			Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "SA", "");
			System.out.println("Schema = " + c.getSchema());

			Statement statement = c.createStatement();
			ResultSet resultSet;

			resultSet = statement.executeQuery("select * from customer");

			ResultSetMetaData meta   = resultSet.getMetaData();
			/*
			String[] columnsNames = new String[meta.getColumnCount()];
			System.out.println(meta.getColumnCount());
			for (int i = 1; i <= columnsNames.length; i++) {
				columnsNames[i-1] = meta.getColumnName(i);
				System.out.println(columnsNames[i-1]);
			}
			*/

			List<Customer> customerList = new ArrayList<Customer>();

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt(meta.getColumnName(1)));
				customer.setEmail(resultSet.getString(meta.getColumnName(2)));
				customerList.add(customer);
			}

			model.addAttribute("customerList", customerList);


//			resultSet = statement.executeQuery("select * from voucher");

//			resultSet = statement.executeQuery("select * from customer_voucher");


		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		}



		return "DB_Status";
	}

}