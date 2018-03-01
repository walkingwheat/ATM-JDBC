package com.feicui.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.feicui.atm.entity.User;
import com.feicui.atm.utils.DBUtils;

/**
 * @author hp
 *
 */
public class AdminDao extends BaseDao {

	private static List<User> list;

	/**
	 * 管理员查询方法 (数据的查询)用excuteQuery方法
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
			ps = conn.prepareStatement("select * from db_user where userType = 0");// 0代表普通用户，1代表已销账户，2代表已锁定账户

			// 4.使用该类的对象操作数据库并得到结果集
			rs = ps.executeQuery();
			// 5.遍历结果集
			while (rs.next()) {
				// 得到数据库中的id
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				int userType = rs.getInt("userType");
				String idCard = rs.getString("idCard");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String address = rs.getString("address");
				String remark = rs.getString("remark");
				double balance = rs.getDouble("balance");
				String cardNumber = rs.getString("cardNumber");
				String password = rs.getString("password");
				// 将从数据库得到的数据封装成User对象
				user = new User(id, userName, userType, idCard, sex, birthday, address, remark, balance, cardNumber,
						password);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 
	 * @param user
	 * @return 检索已销账户
	 */
	public static List<User> queryDeleteAccount(User user) {

		list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// 1.加载驱动
			// 2.建立数据库连接
			conn = DBUtils.getConn();
			// 3.得到数据库里的类
			ps = conn.prepareStatement("select * from db_user where userType = 1");// 0代表普通用户，1代表已销账户，2代表已锁定账户

			// 4.使用该类的对象操作数据库并得到结果集
			rs = ps.executeQuery();
			// 5.遍历结果集
			while (rs.next()) {
				// 得到数据库中的id
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				int userType = rs.getInt("userType");
				String idCard = rs.getString("idCard");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String address = rs.getString("address");
				String remark = rs.getString("remark");
				double balance = rs.getDouble("balance");
				String cardNumber = rs.getString("cardNumber");
				String password = rs.getString("password");
				// 将从数据库得到的数据封装成User对象
				user = new User(id, userName, userType, idCard, sex, birthday, address, remark, balance, cardNumber,
						password);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 检索已锁定账户
	 * 
	 * @param user
	 * @return
	 */
	public static List<User> queryLockAccount(User user) {

		list = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// 1.加载驱动
			// 2.建立数据库连接
			conn = DBUtils.getConn();
			// 3.得到数据库里的类
			ps = conn.prepareStatement("select * from db_user where userType = 2");// 0代表普通用户，1代表已销账户，2代表已锁定账户

			// 4.使用该类的对象操作数据库并得到结果集
			rs = ps.executeQuery();
			// 5.遍历结果集
			while (rs.next()) {
				// 得到数据库中的id
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				int userType = rs.getInt("userType");
				String idCard = rs.getString("idCard");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String address = rs.getString("address");
				String remark = rs.getString("remark");
				double balance = rs.getDouble("balance");
				String cardNumber = rs.getString("cardNumber");
				String password = rs.getString("password");
				// 将从数据库得到的数据封装成User对象
				user = new User(id, userName, userType, idCard, sex, birthday, address, remark, balance, cardNumber,
						password);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 解除锁定账户
	 * 
	 * @param cardnumber
	 * @return
	 */
	public static void relieveLockAccount(String cardnumber) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			// 1.加载驱动
			// 2.建立数据库连接
			conn = DBUtils.getConn();
			// 3.得到数据库里的类
			ps = conn.prepareStatement("update db_user set userType = ? where cardNumber = ?");// 0代表普通用户，1代表已销账户，2代表已锁定账户
			ps.setString(1, "0");
			ps.setString(2, cardnumber);

			// 4.使用该类的对象操作数据库并得到结果集
			int count = ps.executeUpdate();
			// 5.遍历结果集
			// while (rs.next()) {
			// // 得到数据库中的id
			// int id = rs.getInt("id");
			// String userName = rs.getString("userName");
			// int userType = rs.getInt("userType");
			// String idCard = rs.getString("idCard");
			// String sex = rs.getString("sex");
			// Date birthday = rs.getDate("birthday");
			// String address = rs.getString("address");
			// String remark = rs.getString("remark");
			// double balance = rs.getDouble("balance");
			// String cardNumber = rs.getString("cardNumber");
			// String password = rs.getString("password");
			// // 将从数据库得到的数据封装成User对象
			// user = new User(id, userName, userType, idCard, sex, birthday, address,
			// remark, balance, cardNumber,
			// password);
			// list.add(user);
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
	}
	
	/**
	 * 重置密码
	 */
	public String resetPassword(String cardNumber,String newPassword) {
		System.out.println("******"+ cardNumber);
		System.out.println("******"+ newPassword);

		Connection conn = null;
		ResultSet st = null;
		PreparedStatement ps = null;
		// 1.注册驱动
		// 2.创建连接
		conn = DBUtils.getConn();
		try {
			// 3.得到数据库里的类
			ps = conn.prepareStatement("update db_user set password = ? where cardNumber = ?");
			ps.setString(1, newPassword);
			ps.setString(2, cardNumber);
			
			st = ps.executeQuery();
			return newPassword;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return "没有此用户";
	}
	

	/**
	 * 数据的增加 insert into
	 * 
	 * 数据的增加、删除、修改用excuteUpdate方法
	 * 
	 * @param user
	 * @return
	 * @return
	 */
	public static boolean addAccount(User user) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 1.加载驱动
		// 2.建立数据库链接
		conn = DBUtils.getConn();
		try {

			// 3.得到执行SQL语句的Statement对象
			String sql = "insert into db_user(id,userName,userType,idCard,sex,birthday,address,remark,balance,cardNumber,password)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getId());
			System.out.println(user.getId());
			ps.setString(2, user.getUserName());
			ps.setInt(3, user.getUserType());
			ps.setString(4, user.getIdCard());
			ps.setString(5, user.getSex());
			ps.setObject(6, user.getBirthday());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getRemark());
			ps.setDouble(9, user.getBalance());
			ps.setString(10, user.getCardNumber());
			ps.setString(11, user.getPassword());

			int count = ps.executeUpdate();// 返回几行数据被影响
			// return count == 1;
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return false;

	}

	/**
	 * 查询用户id值是传入id值得那个user对象
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id) {

		if (list != null) {

			for (User user : list) {
				if (id.equals(user.getId())) {
					return user;
				}
			}
		}
		return null;

	}

	/**
	 * 查询数据库最大id
	 * 
	 * @return
	 */
	public int queryMaxId() {

		Connection conn = null;
		ResultSet st = null;
		PreparedStatement ps = null;
		// 1.注册驱动
		// 2.创建连接
		conn = DBUtils.getConn();
		try {
			// 3.得到数据库里的类
			ps = conn.prepareStatement("select MAX(id) from db_user");

			st = ps.executeQuery();
			while (st.next()) {

				int id = st.getInt("MAX(id)");
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return 0;
	}

	/**
	 * 查询卡号的方法
	 * 
	 * @return
	 */
	public String queryCardNumber() {

		Connection conn = null;
		ResultSet st = null;
		PreparedStatement ps = null;
		// 1.注册驱动
		// 2.创建连接
		conn = DBUtils.getConn();
		try {
			// 3.得到数据库里的类
			ps = conn.prepareStatement("select cardNumber from db_user");

			st = ps.executeQuery();
			while (st.next()) {

				String cardNumber = st.getString("cardNumber");
				return cardNumber;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return "没有此用户";
	}

	/**
	 * 根据卡号删除用户
	 * 
	 * @param deleteCardNumber
	 * @return
	 */
	public static boolean deleteAccountByCardNumber(String deleteCardNumber) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 1.加载驱动
		// 2.建立数据库链接
		conn = DBUtils.getConn();
		try {

			// 3.得到执行SQL语句的Statement对象
			// String sql = "insert into
			// db_user(id,userName,userType,idCard,sex,birthday,address,remark,balance,cardNumber,password)"
			// + "values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement("delete from db_user where cardNumber = ?");
			ps.setString(1, deleteCardNumber);

//			ps.setInt(1, deleteCardNumber.getId());

			int count = ps.executeUpdate();// 返回几行数据被影响
			return count == 1;
			// return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return false;

	}

}
