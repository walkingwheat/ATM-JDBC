package com.feicui.atm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库链接工具包
 * 
 * 1.获取数据库的连接
 * 2.关闭所有资源
 * @author hp
 *
 */
public class DBUtils {
	
	/**
	 * 获取数据库链接的方法
	 * @return
	 */
	public static Connection getConn() {
		
		Connection conn = null;
		
		 try {
			 // 1.加载驱动
			 Class.forName("com.mysql.jdbc.Driver");
			 // 2.建立数据库链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭所有资源
	 */
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) {
		
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
