package com.feicui.atm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.feicui.atm.dao.PeopleDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.utils.CommonUtils;

public class PeopleService {
	
	List<User> list = new ArrayList();

	User user = new User();
	private PeopleDao peopleDao;
	
	public void deposit(double inputDepositMoney) {
		
		peopleDao.depositMoney(inputDepositMoney);
	}
}
