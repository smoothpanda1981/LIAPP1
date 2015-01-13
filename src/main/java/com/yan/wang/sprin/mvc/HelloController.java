package com.yan.wang.sprin.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;

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
			dump(resultSet);

			resultSet = statement.executeQuery("select * from voucher");
			dump(resultSet);

			resultSet = statement.executeQuery("select * from customer_voucher");
			dump(resultSet);


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



	public void dump(ResultSet rs) throws SQLException {

		// the order of the rows in a cursor
		// are implementation dependent unless you use the SQL ORDER statement
		ResultSetMetaData meta   = rs.getMetaData();
		int               colmax = meta.getColumnCount();
		int               i;
		Object            o = null;

		// the result set is a cursor into the data.  You can only
		// point to one row at a time
		// assume we are pointing to BEFORE the first row
		// rs.next() points to next row and returns true
		// or false if there is no next row, which breaks the loop
		System.out.println("___________________________________________________");
		for (; rs.next(); ) {
			for (i = 0; i < colmax; ++i) {
				o = rs.getObject(i + 1);    // Is SQL the first column is indexed

				// with 1 not 0
				System.out.print(o.toString() + " ");
			}

			System.out.println(" ");
		}
	}
}