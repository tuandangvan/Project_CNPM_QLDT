package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {

	    private final String serverName = "DESKTOP-IK5D1LO"; 
	    private final String dbName = "DangKyDeTai"; 
	    private final String portNumber = "1433";
	    private final String instance = "SQLEXPRESS";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE 
	    private final String userID = "sa";
	    private final String password = "123456";
	 
//	private final String serverName = "VANTUAN";
//	private final String dbName = "QuanLyDeTai";
//	private final String portNumber = "1433";
//	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//	private final String userID = "sa";
//	private final String password = "12345";
	
//	 private final String serverName = "DESKTOP-8AGARKU";
//	 private final String dbName = "QuanLyDeTai";
//	 private final String portNumber = "1433";
//	 private final String instance = "HUY";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//	 private final String userID = "sa";
//	 private final String password = "huy";



	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
