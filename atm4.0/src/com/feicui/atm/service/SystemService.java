package com.feicui.atm.service;

import java.util.Scanner;

import com.feicui.atm.dao.PeopleDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.utils.CommonUtils;

public class SystemService extends BaseService {

	private PeopleService peopleService;
	private PeopleDao peopleDao;

	User user = new User();

	public void systemLogin(Scanner scanner) {

		System.out.print(CommonUtils.getPropValue("T004"));

		String adminInputName = scanner.next();

		if (!adminInputName.equals("admin")) {
			System.out.println(CommonUtils.getPropValue("E003"));
		}

		System.out.print(CommonUtils.getPropValue("T005"));
		String adminInputPassword = scanner.next();

		if (!adminInputPassword.equals("123456")) {
			System.out.println(CommonUtils.getPropValue("E004"));
		}
	}

	public void peopleLogin(Scanner scanner) {

		peopleDao = new PeopleDao();

		System.out.print(CommonUtils.getPropValue("A001"));
		String peopleInputCardNumber = scanner.next();

		while (true) {

			if (peopleInputCardNumber.equals(peopleDao.queryOrdinaryAccount(user).get(0))) {

			} else {
				System.out.println(CommonUtils.getPropValue("B001"));

			}
			break;
		}

		while (true) {

			System.out.println(CommonUtils.getPropValue("A002"));
			String peoplePassword = scanner.next();

			if (peoplePassword.equals(peopleDao.queryOrdinaryAccount(user).get(1))) {

			} else {

				System.out.println(CommonUtils.getPropValue("B002"));
			}
			break;
		}
	}

}
