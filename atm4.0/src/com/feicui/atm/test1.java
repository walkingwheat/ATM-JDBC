package com.feicui.atm;

import com.feicui.atm.dao.SystemDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.utils.AdminUtils;

public class test1 {
	public static void main(String[] args) {

//		System.out.println(AdminUtils.addCard());
		User user = new User("Admin","123456");
//		user.setSex("1");
//		user.setBirthday("");
		
//		AdminUtils.addCard(user);
		
		
		if (SystemDao.login(user)) {
			System.out.println("登录成功");
		}else{
			System.out.println("登陆失败");
		}
		
	}

}
