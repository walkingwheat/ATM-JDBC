package com.feicui.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.feicui.atm.entity.User;
import com.feicui.atm.utils.DBUtils;

public class PeopleDao extends BaseDao{
	
	private static List<User> list;

	/**
	 * 管理员查询方法 数据的查询用excuteQuery方法
	 * 
	 * @param user
	 * @return
	 */
	public static List<User> queryOrdinaryAccount(User user) {

		list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// 1.加载驱动
			// 2.建立数据库连接
			conn = DBUtils.getConn();
			// 3.得到数据库里的类
			ps = conn.prepareStatement("select cardNumber,password from db_user where userType = 0");// 0代表普通用户，1代表已销账户，2代表已锁定账户

			// 4.使用该类的对象操作数据库并得到结果集
			rs = ps.executeQuery();
			// 5.遍历结果集
			while (rs.next()) {
				// 得到数据库中的id
				String cardNumber = rs.getString("cardNumber");
				String password = rs.getString("password");
				// 将从数据库得到的数据封装成User对象
				user = new User(cardNumber,password);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return list;
//		return null;
		
		
	}
	
	
//	public static String queryOrdinaryAccountPassword(String peoplePassword) {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//
//			// 1.加载驱动
//			// 2.建立数据库连接
//			conn = DBUtils.getConn();
//			// 3.得到数据库里的类
//			ps = conn.prepareStatement("select peoplePassword from db_user where userType = 0");// 0代表普通用户，1代表已销账户，2代表已锁定账户
//
//			// 4.使用该类的对象操作数据库并得到结果集
//			rs = ps.executeQuery();
//			// 5.遍历结果集
//			while (rs.next()) {
//				// 得到数据库中的id
//				String peoplepassword = rs.getString("peoplePassword");
////				String password = rs.getString("password");
//				// 将从数据库得到的数据封装成User对象
////				user = new User(cardNumber,password);
////				list.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtils.closeAll(conn, ps, rs);
//		}
////		return list;
//		return peoplePassword;
//		
//	}
	
	//存款 数据库
	public static double depositMoney(double inputDepositMoney) {
		
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
		
				try {
		
					// 1.加载驱动
					// 2.建立数据库连接
					conn = DBUtils.getConn();
					// 3.得到数据库里的类
					ps = conn.prepareStatement("select peoplePassword from db_user where userType = 0");// 0代表普通用户，1代表已销账户，2代表已锁定账户
		
					// 4.使用该类的对象操作数据库并得到结果集
					rs = ps.executeQuery();
					// 5.遍历结果集
					while (rs.next()) {
						// 得到数据库中的id
						String peoplepassword = rs.getString("peoplePassword");
//						String password = rs.getString("password");
						// 将从数据库得到的数据封装成User对象
//						user = new User(cardNumber,password);
//						list.add(user);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtils.closeAll(conn, ps, rs);
				}
//				return list;
				return inputDepositMoney;
				
				
			}
}
