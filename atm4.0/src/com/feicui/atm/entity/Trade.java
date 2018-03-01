package com.feicui.atm.entity;

import java.util.Date;

public class Trade {

	private int id;// 主键
	private String cardNumber;// 源账户
	private String tradeAccount;// 目标账户
	private int tradeType;// 账务类型 1:存款 2:取款 3: 转账-支出 4:转账-收入
	private Date tradeDate;// 账务时间 yyyy-MM-dd hh:mm:ss
	private double tradeAmount;// 交易金额
	private double afterAmount;// 交易后账户金额

	public Trade(int id, String cardNumber, String tradeAccount, int tradeType, Date tradeDate, double tradeAmount,
			double afterAmount) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.tradeAccount = tradeAccount;
		this.tradeType = tradeType;
		this.tradeDate = tradeDate;
		this.tradeAmount = tradeAmount;
		this.afterAmount = afterAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public double getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public double getAfterAmount() {
		return afterAmount;
	}

	public void setAfterAmount(double afterAmount) {
		this.afterAmount = afterAmount;
	}

	@Override
	public String toString() {
		return "Trade [主键=" + id + ", 源账户=" + cardNumber + ", 目标账户=" + tradeAccount + ", 账务类型="
				+ tradeType + ", 账务时间=" + tradeDate + ", 交易金额=" + tradeAmount + ", 交易后账户余额="
				+ afterAmount + "]";
	}
	
	
}
