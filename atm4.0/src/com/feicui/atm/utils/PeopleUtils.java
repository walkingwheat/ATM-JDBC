package com.feicui.atm.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.feicui.atm.entity.User;

public class PeopleUtils {

	public static void testMoney(double inputDepositMoney) {

		while (true) {

			// 如果存款金额不是100的整数倍,则重新输入
			if (inputDepositMoney % 100 == 0 && inputDepositMoney > 0) {

				break;
			} else if (inputDepositMoney % 100 != 0 || inputDepositMoney < 0) {

				// 输入存款金额不是100的整数倍,则提示重新输入
				System.out.println("请输入0以上且为100的整数倍存款金额!");

			} else {

				System.out.println("输入有误,请重新输入!");
			}

		}

		// double inputDepositMoney = 0;
		// while (true) {
		//
		// // money = Scan.scanDouble();
		//
		// // 判断输入的取款金额是不是100的整数倍并且是否小于等于账户余额
		// if (inputDepositMoney % 100 == 0 && inputDepositMoney <= user.getBalance() &&
		// inputDepositMoney >= 0) {
		//
		// break;
		// } else if (inputDepositMoney % 100 != 0 && inputDepositMoney <=
		// user.getBalance()
		// || inputDepositMoney < 0) {
		// System.out.println("请输入大于0的100的整数倍取款金额!");
		//
		// } else if (inputDepositMoney % 100 != 0 && inputDepositMoney >
		// user.getBalance()) {
		// System.out.println("余额不足,请输入100的整数倍取款金额!");
		//
		// } else if (inputDepositMoney % 100 == 0 && inputDepositMoney >
		// user.getBalance()) {
		// System.out.println("余额不足!");
		//
		// } else {
		// System.out.println("输入有误,请重新输入!");
		// }
		// }
	}

	// 存款钱的验证
	public static void qrMenthed(User user, int inputNum, double inputDepositMoney) {

		while (true) {

			// dIndex2 = Scan.scanString();
			if ("1".equals(inputNum)) {

				// 如果确认存款,则更新当前用户流水信息与用户余额信息
				double balance = user.getBalance() + inputDepositMoney;
				user.setBalance(balance);

				// String sql = "update atm_user set balance = " + user.getBalance() + " where
				// account = '"
				// + user.getAccount() + "';";
				// UpdateBalanceDao ubd = new UpdateBalanceDao();
				// ubd.updateMoney(sql);

				Connection conn = null;
				ResultSet st = null;
				PreparedStatement ps = null;
				// 1.注册驱动
				// 2.创建连接
				conn = DBUtils.getConn();
				try {
					// 3.得到数据库里的类
					ps = conn.prepareStatement("update db_user set password = ? where cardNumber = ?");
					ps.setDouble(1, user.getBalance());
					ps.setString(2, user.getCardNumber());

					st = ps.executeQuery();
					// return newPassword;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtils.closeAll(conn, ps, null);
				}
				// return "没有此用户";

				// // 存储流水
				// String id = CommonUtils.formatUtil("yyyyMMddHHmmssSSS", new Date());
				// String time = CommonUtils.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());
				// String targetAccount = user.getAccount();
				// AddBillDao abd = new AddBillDao(user);
				// abd.addBillDao(id, targetAccount, time, money);
				//
				// // 存款成功之后提示存款成功,并返回上一级
				// System.out.println("成功存款:" + inputDepositMoney + "元");
				// System.out.println("存款时间:" + dTime);
				// System.out.println("存款成功,正在返回主菜单!");
				// System.out.println("返回主菜单成功!");
				// break here;
				//
				// } else if ("2".equals(inputNum)) {
				//
				// // 如果输入2,则重新选择存款金额
				// break;
				//
				// } else if ("3".equals(inputNum)) {
				//
				// // 如果输入3,则返回主菜单
				// System.out.println("正在返回主菜单!");
				// System.out.println("返回主菜单成功!");
				// break here;
				//
				// } else {
				//
				// // 输入其他按键提示输入有误,并重新输入
				// System.out.println("输入有误,请重新输入!");
				//
				//
			}
		}

	}
}
