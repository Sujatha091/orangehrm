package com.hrmapp.orange.orangehrm.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hrmapp.orange.orangehrm.Exceptions.ExplicitAssertionError;

public class DBUtils {
	
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	public static void loadDatabase() throws ClassNotFoundException, SQLException, ExplicitAssertionError{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orangehrm_mysql", "root","");
	}
	
	public static boolean getResult(String name) throws SQLException{
		st=con.createStatement();
		rs=st.executeQuery("select user_name from ohrm_user where user_name='"+name+"';");
		String str=null;
		while (rs.next()){
			str=rs.getString("user_name");
			System.out.println("str"+str);
			if (str.equalsIgnoreCase(name)){
				return true;
			}
		}
		return false;
	}
}
