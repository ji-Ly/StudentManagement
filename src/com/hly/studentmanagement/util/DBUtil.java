package com.hly.studentmanagement.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// make a connection
	public static Connection makeConnection() {

		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-71ECDJR\\SQLEXPRESS;databaseName=STUDENT; encrypt = false",
					"sa",
					"a123456789");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// close a connection
	public static void closeConnection(Connection connection) {
		if (connection != null)
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	// main to test connection
//	public static void main(String[] args) throws SQLException {
//		Connection connection = makeConnection();
//		DatabaseMetaData dm = connection.getMetaData();
//		System.out.println("Make connection to database successfully!");
//		System.out.println("Driver name: " + dm.getDriverName());
//		System.out.println("Driver version: " + dm.getDriverVersion());
//		closeConnection(connection);
//		System.out.println("Close connection!");
//
//	}

}
