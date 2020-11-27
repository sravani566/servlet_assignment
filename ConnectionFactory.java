package com.demo;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory 
{
	
		private static Connection conn = null;
		private ConnectionFactory() {}
		
		public static Connection getConnection() {
			
			InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			
			try {
				properties.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String driverName = properties.getProperty("db.driverName");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");
			
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
			return conn;
		}
}

	
