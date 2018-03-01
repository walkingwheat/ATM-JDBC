package com.feicui.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.feicui.atm.entity.User;

public class SystemDao {
	
	public static boolean login(User user) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 2.建立数据库连接
			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root",
			// "123456");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?user=root&password=123456");
			// System.out.println(conn);

			// 3.打到数据库里的类
			st = conn.createStatement();

			// 4.使用该类的对象操作数据库并得到结果集
			rs = st.executeQuery(
					"select * from db_user where userName ='"+user.getUserName()+"' and passWord = '"+user.getPassword()+"'");
			// 5.遍历结果集
			if (rs.next()) {//查询到一条记录
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					if (st!=null) {
						st.close();
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
		return false;
		
	}
}
