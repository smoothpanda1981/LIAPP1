package com.yan.wang.sprin.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.DriverManager;

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



		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		}
		return "DB_Status";
	}


	// http://rajadileepkolli.wordpress.com/2011/12/23/hsqldb-in-ubuntu/

	// Recent settings
	// HSQL Database Engine Server
	// org.hsqldb.jdbcDriver
	// jdbc:hsqldb:hsql://localhost/

	// java -cp ./lib/hsqldb.jar org.hsqldb.server.Server
	// java -cp ./lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
}