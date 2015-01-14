package com.yan.wang.sprin.mvc;

import com.yan.wang.sprin.mvc.dao.Customer;
import com.yan.wang.sprin.mvc.dao.CustomerVoucher;
import com.yan.wang.sprin.mvc.dao.Voucher;
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

	@RequestMapping(value = "db", method = RequestMethod.GET)
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


			resultSet = statement.executeQuery("select * from voucher");
			meta   = resultSet.getMetaData();
			List<Voucher> voucherList = new ArrayList<Voucher>();
			while (resultSet.next()) {
				Voucher voucher = new Voucher();
				voucher.setVoucher_id(resultSet.getInt(meta.getColumnName(1)));
				voucher.setVoucher_text(resultSet.getString(meta.getColumnName(2)));
				voucher.setCompany_name(resultSet.getString(meta.getColumnName(3)));
				voucherList.add(voucher);
			}
			model.addAttribute("voucherList", voucherList);


			resultSet = statement.executeQuery("select * from customer_voucher");
			meta   = resultSet.getMetaData();
			List<CustomerVoucher> customerVoucherList = new ArrayList<CustomerVoucher>();
			while (resultSet.next()) {
				CustomerVoucher customerVoucher = new CustomerVoucher();
				customerVoucher.setId(resultSet.getInt(meta.getColumnName(1)));
				customerVoucher.setCustomer_id(resultSet.getInt(meta.getColumnName(2)));
				customerVoucher.setVoucher_id(resultSet.getInt(meta.getColumnName(3)));
				customerVoucherList.add(customerVoucher);
			}
			model.addAttribute("customerVoucherList", customerVoucherList);

		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		}
		return "DB_Status";
	}

}