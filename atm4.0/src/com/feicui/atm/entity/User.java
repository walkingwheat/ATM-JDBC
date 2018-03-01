package com.feicui.atm.entity;

import java.util.Date;

/**
 * 与数据库中db_user表对应的实体类
 * 
 * @author 行走的麦子
 *
 */
public class User {
	private int id;
	private String userName;
	private int userType;
	private String idCard;
	private String sex;
	private Date birthday;
	private String address;
	private String remark;
	private double balance;
	private String cardNumber;
	private String password;

	public User() {
		super();
	}

	

	public User(int id, String userName, int userType, String idCard, String sex, Date birthday, String address,
			String remark, double balance, String cardNumber, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.userType = userType;
		this.idCard = idCard;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.remark = remark;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.password = password;
	}



	public User(String userName, int userType, String idCard, String sex, Date birthday, String address, String remark,
			double balance, String cardNumber, String password) {
		super();
		this.userName = userName;
		this.userType = userType;
		this.idCard = idCard;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.remark = remark;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.password = password;
	}

	public User(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	
	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [主键=" + id + ", 用户名=" + userName + ", 账号状态=" + userType + ", 身份证号=" + idCard + ", 性别="
				+ sex + ", 出生日期=" + birthday + ", 家庭住址=" + address + ", 备注=" + remark + ", 账户余额="
				+ balance + ", 卡号=" + cardNumber + ", 密码=" + password + "]";
	}

	
}
