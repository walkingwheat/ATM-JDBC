package com.feicui.atm.controller;

import java.util.Scanner;

import com.feicui.atm.service.PeopleService;
import com.feicui.atm.service.SystemService;
import com.feicui.atm.utils.CommonUtils;
import com.feicui.atm.view.AdminView;


public class SystemController extends BaseController{
	
	private AdminView adminView;
	private SystemService systemService;
	private PeopleService peopleService;
	
	
	//选择管理员登录  或者  普通用户登录
	@Override
	public String excute(Scanner scanner) {
		systemService = new SystemService();
		
//		adminView = new AdminView();
//		adminView.showAdminFunction();
		
		System.out.println("1.管理员登录	2.普通用户登录");
		String inputChoice = scanner.next();
		
		String result = null;
		
		if ("1".equals(inputChoice)) {
			
			systemService.systemLogin(scanner);
			System.out.println(CommonUtils.getPropValue("S002"));
			
			result = "admin";
			
		} else if("2".equals(inputChoice)){
			
			systemService.peopleLogin(scanner);
			System.out.println(CommonUtils.getPropValue("S002"));
			
			result = "people";
		}
		return result;
	}
	
	
}
