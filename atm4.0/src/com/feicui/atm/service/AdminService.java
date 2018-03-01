package com.feicui.atm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.feicui.atm.dao.AdminDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.utils.AdminUtils;

public class AdminService extends BaseService {

	User user = new User();

	private AdminDao adminDao;

	// 添加用户名的方法
	public String addUserName(String userName) {

		adminDao = new AdminDao();

		// String userName;

		// 如果输入的姓名不符合要求格式,则返回重新输入
		while (true) {

			// userName = Scan.scanString();

			// 如果输入的用户名长度大于20或等于0,给出错误信息
			if (userName.length() > 20 || userName.length() == 0) {

				System.out.println("输入有误,请输入大于0且小于20位长度的姓名!");
				continue;
			}
			user.setUserName(userName);
			break;
		}
		return userName;

	}

	// 添加身份证号的方法
	public String addIdCard(String idCard) {
		// 如果输入的身份证号不符合要求格式,则返回重新输入
		while (true) {

			// idCard = Scan.scanString();

			// 身份证号由18位数字组成,输入不符合规范则重新进行输入
			if (!idCard.matches("[0-9]{17}[0-9x]{1}")) {

				System.out.println("输入有误,请输入18位数字的身份证号!");
				continue;
			}
			user.setIdCard(idCard);
			break;
		}
		return idCard;

	}

	// 添加性别的方法
	public String addSex(String sex) {
		while (true) {

			// gender = Scan.scanInt();

			// 如果输入1,储存结果
			if ("1".equals(sex)) {

				user.setSex(sex);
				break;

			} else if ("2".equals(sex)) {

				user.setSex(sex);
				break;

			} else {

				System.out.println("输入有误,请输入1或2选择性别!");
			}
		}
		return sex;
	}

	// 添加出生日期的方法
	public String addBirthday(String string) {

		while (true) {

			// birthday = Scan.scanString();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				user.setBirthday(sdf.parse(string));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;

		}
		return string;

	}

	// 添加家庭住址的方法
	public String addAddress(String address) {

		while (true) {

			// address = Scan.scanString();
			if (address.length() > 50 || address.length() == 0) {

				System.out.println("输入有误,请输入长度不等于0且不大于50的联系地址!");
				continue;

			}

			user.setAddress(address);
			break;
		}
		return address;

	}

	/**
	 * 添加备注的方法
	 * 
	 * @param remark
	 * @return
	 */
	public boolean addRemark(String remark) {

		// address = Scan.scanString();
		if (remark.length() <= 200) {

			user.setRemark(remark);
			System.out.println("+++++   " + user.getRemark());
			return true;
		}

		// str = prop.getProperty("a13");
		System.out.println("输入超出最大长度");
		// System.out.println(str);
		return false;

	}

	/**
	 * 添加余额的方法
	 * 
	 * @param balance
	 */
	public void addBalance(double balance) {
		user.setBalance(balance);
	}

	/**
	 * 添加卡号的方法
	 * 
	 * @return
	 */
	public String addCardNumber() {

		System.out.println(AdminUtils.addCard(user));

		user.setCardNumber(AdminUtils.addCard(user));

		return user.getCardNumber();

		// System.out.println("你的卡号是：");

		// return AdminUtils.addCard(user);

		// user.setCardNumber(AdminUtils.addCard(user));

	}

	// 添加密码的方法
	public String addPassWord(String password) {

		while (true) {

			// password = Scan.scanString();

			if (!password.matches("[0-9a-zA-Z]{6}")) {

				System.out.println("请按规定格式输入密码!");
				continue;
			}
			user.setPassword(password);
			break;
		}
		return password;

	}

	/**
	 * 查找id的最大值
	 */
	public void queryId() {

		adminDao.queryMaxId();
		int number = user.setId(adminDao.queryMaxId() + 1);
		System.out.println("最大id是:" + number);
	}

	public void openAccount() {

		// ps.setInt(1, user.getId());
		// System.out.println(user.getId());
		// ps.setString(2, user.getUserName());
		// ps.setInt(3, user.getUserType());
		// ps.setString(4, user.getIdCard());
		// ps.setString(5, user.getSex());
		// ps.setObject(6, user.getBirthday());
		// ps.setString(7, user.getAddress());
		// ps.setString(8, user.getRemark());
		// ps.setDouble(9, user.getBalance());
		// ps.setString(10, user.getCardNumber());
		// ps.setString(11, user.getPassword());

		// System.out.println("id " + user.getId());
		// System.out.println("用户名 " + user.getUserName());
		// System.out.println("类型 " + user.getUserType());
		// System.out.println("省份证号 " + user.getIdCard());
		// System.out.println("性别 " + user.getSex());
		// System.out.println("生日 " + user.getBirthday());
		// System.out.println("地址 " + user.getAddress());
		// System.out.println("备注 " + user.getRemark());
		// System.out.println("余额 " + user.getBalance());
		// System.out.println("卡号 " + user.getCardNumber());
		// System.out.println("密码 " + user.getPassword());

		adminDao.addAccount(user);
	}

	/**
	 * 创建销户的方法
	 * 
	 * @param deleteCardNumber
	 */
	public void deleteAccount(String deleteCardNumber) {

		if (deleteCardNumber.equals(adminDao.queryCardNumber())) {

			adminDao.deleteAccountByCardNumber(deleteCardNumber);
		} else {

			System.out.println("账号不存在");
		}

		adminDao.queryCardNumber();
	}

	/**
	 * 0代表普通用户，1代表已销账户，2代表已锁定账户 查询普通用户的方法
	 */
	public void queryOrdinary() {

		for (User user : adminDao.queryOrdinaryAccount(user)) {
			System.out.println(user);
		}

	}

	/**
	 * 查询已销账户
	 */
	public void queryDelete() {

		for (User user : adminDao.queryDeleteAccount(user)) {
			System.out.println(user);
		}
	}

	/**
	 * 检索已锁定账户
	 */
	public void queryLock() {

		for (User user : adminDao.queryLockAccount(user)) {
			if (user == null) {
				System.out.println("没有锁定账户");
			} else {
				System.out.println(user);

			}
		}
	}

	/**
	 * 解除已锁用户
	 * 
	 * @param cardnumber
	 */
	public void relieveLock(String cardnumber) {

		adminDao.relieveLockAccount(cardnumber);
	}

	/**
	 * 重置密码
	 */
	public void reset(String cardNumber, String newPassword) {
		System.out.println(cardNumber);
		System.out.println(newPassword);

		adminDao.resetPassword(cardNumber, newPassword);

		System.out.println("hehe ");

	}
}
