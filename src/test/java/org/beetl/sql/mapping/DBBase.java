package org.beetl.sql.mapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.beetl.sql.DBConfig;

public class DBBase {
	
	private DBBase(){}
	private static DBBase base = new DBBase();
	public static DBBase getInstance(){
		return base;
	}
	
	public Connection getConn(){
		String driver = DBConfig.driver;
        String dbName = DBConfig.dbName;
        String password = DBConfig.password;
        String userName = DBConfig.userName;
        String url = DBConfig.url;
        Connection conn = null;
        try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet getRs(Connection conn ,String sql){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
