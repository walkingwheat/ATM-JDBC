package com.feicui.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.feicui.atm.entity.User;

public class test {

	public static void main(String[] args) {
		
		text(user);
	}

	public void text(User user) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立数据库链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "123456");
			// 3.得到执行SQL语句的Statement对象
			
			ps = conn.prepareStatement(
					"insert into db_user(id,userName,userType,idCard,sex,birthday,address,remark,balance,cardNumber,password)values(?,?,?,?,?,?,?,?,?,?,?)");
//			ps = conn.prepareStatement(
//					"insert into db_user(id,userName,userType,idCard,sex,birthday,address,remark,balance,cardNumber,password)values('?','?','?','?','?','?','?','?','?','?','?')");
			
			ps.setInt(1, user.getId());
//			System.out.println(user.getId());
			ps.setString(2, user.getUserName());
			System.out.println("----------------------------------=======================--------------");
			ps.setInt(3, user.getUserType());
			ps.setString(4, user.getIdCard());
			ps.setString(5, user.getSex());
			ps.setObject(6, user.getBirthday());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getRemark());
			ps.setDouble(9, user.getBalance());
			ps.setString(10, user.getCardNumber());
			ps.setString(11, user.getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 取得User表中的全部数据，并封装为List集合
	 */

}
