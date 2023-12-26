package Commodity.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		Properties pro = new Properties();
		try {
			pro.load(JdbcUtils.class.getResourceAsStream("db.properties"));
			driver = pro.getProperty("d");
			url = pro.getProperty("u");
			user = pro.getProperty("us");
			password = pro.getProperty("p");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection geCon() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void closeConn(ResultSet rs, Statement stat, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}