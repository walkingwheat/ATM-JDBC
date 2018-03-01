package com.feicui.atm.utils;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.feicui.atm.entity.User;

/**
 * 管理员工具类
 * 
 * @author 行走的麦子
 *
 */
public class AdminUtils {

	public static String inputBirthday() {

//		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String birthday = scanner.nextLine();
		// scanner.close();
		return birthday;

	}

	// 生成账号
	public static String addCard(User user) {

		// 账号 BC18 + 性别(男01:女02) + 出生日期 + 4位随机号
		// 截取身份证号的出生日期 前闭后开
		String sex = user.getSex();

//		Date birthday = user.getBirthday();
		
		String str = user.getIdCard().substring(6, 14);
//		System.out.println(str);

		// 设置随机数
		Random random = new Random();

		String cardNUmber = "BC180" + sex + str + random.nextInt(9) + "" + random.nextInt(9) + ""
				+ random.nextInt(9) + "" + random.nextInt(9);

		return cardNUmber;
	}

}
