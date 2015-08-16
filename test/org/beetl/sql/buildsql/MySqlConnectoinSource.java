/**
 * 
 */
package org.beetl.sql.buildsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.InterceptorContext;

/**
 * @author suxinjie
 *
 */
public class MySqlConnectoinSource implements ConnectionSource {
	
	private Connection getConn(){
		String driver = "com.mysql.jdbc.Driver";
        String dbName = "test";
        String passwrod = "root";
        String userName = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
        Connection conn = null;
        try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName,
	                passwrod);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public Connection getReadConn(InterceptorContext ctx) {
		return this.getConn();
	}

	@Override
	public Connection getWriteConn(InterceptorContext ctx) {
		return this.getConn();
	}

}
