package com.feicui.atm.controller;

import java.util.Properties;
import java.util.Scanner;

import com.feicui.atm.entity.User;
import com.feicui.atm.service.PeopleService;
import com.feicui.atm.utils.CommonUtils;
import com.feicui.atm.utils.PeopleUtils;
import com.feicui.atm.view.PeopleView;

/**
 * @author hp
 *
 */
public class PeopleController extends BaseController {
	
	User user = new User();
	
	private PeopleService peopleService;
	private PeopleView peopleView;

	@Override
	public String excute(Scanner scanner) {
		
		Properties prop = new Properties();

		peopleView = new PeopleView();

		while (true) {

			System.out.println("请选择操作:");
			 // 1.存款      2.取款	3.转账      4.查询个人信息       5.返回上一级     6.退卡
			peopleView.showPeopleFunction();
			
			String peopleinput = scanner.next();
			
			//1=选择存款
			if ("1".equals(peopleinput)) {
				
				while(true) {
					
//				String wTime = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());
					
					System.out.println(CommonUtils.getPropValue("A003"));
					
					double inputDepositMoney = scanner.nextDouble();
					
					//验证钱 的格式的方法
					PeopleUtils.testMoney(inputDepositMoney);
					
					//显示1.确认\n2.重新输入\n3.返回主菜单
					CommonUtils.printText("qr_funtion.txt");
					
					int inputNum = scanner.nextInt();
					
					//存款后确认的方法
					PeopleUtils.qrMenthed(user,inputNum,inputDepositMoney);
					
					peopleService.deposit(inputDepositMoney);
				}
			}else if("2".equals(peopleinput)) {
				
			}else if("3".equals(peopleinput)) {
				
				
			}else if("4".equals(peopleinput)) {
				
			}else if("5".equals(peopleinput)) {
				
			}else if("6".equals(peopleinput)) {
				
			}
		}

	}

}
