package com.demo;

import java.sql.Connection;

public class Connectionchecker {
	
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		if(conn!=null) {
			System.out.println("done the process");
			System.out.println(conn.getClass());
		}
	}

}
