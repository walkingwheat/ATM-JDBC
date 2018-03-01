package com.feicui.atm.view;

import java.util.List;

import com.feicui.atm.dao.AdminDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.utils.CommonUtils;

public class AdminView {
	
//	private AdminDao adminDao;
//	
//	//通过dao得到数据库内的用户
//	public void showUser(User user) {
//		
//		adminDao.query(user);
//	}
	
	//显示list<User>中的用户
//	public void 3(List<User> list) {
//		
//		for (User user : list) {
//			showUser(user);
//		}
//	}
//	
	
	
	//读取文本1.开户	2.销户	3.检索普通用户	4.检索已销账户	5.检索锁定账户	6.解除锁定账户	7.重置密码             的内容
	public void showAdminFunction() {

		CommonUtils.printText("admin_funtion.txt");
	}
	
	//返回上一级
	public void showAdminFunction1() {

		CommonUtils.printText("admin_view.txt");
	}
}
