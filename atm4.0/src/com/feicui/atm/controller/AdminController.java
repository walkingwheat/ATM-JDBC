package com.feicui.atm.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.feicui.atm.entity.User;
import com.feicui.atm.service.AdminService;
import com.feicui.atm.utils.AdminUtils;
import com.feicui.atm.utils.CommonUtils;
import com.feicui.atm.view.AdminView;

public class AdminController extends BaseController {
	
//	User user = new User();

	private AdminService adminService;
	private AdminView adminView;
	private SystemController systemController;

	@Override
	public String excute(Scanner scanner) {
		
		adminService = new AdminService();
		adminView = new AdminView();

		while (true) {

			// 获取集合中用户集合
//			List<User> listuser = adminService.queryUser();
//
//			if (listuser != null && !listuser.isEmpty()) {
//
//				adminView.showUserList(listuser);
//			}
//			System.out.println("*******123");
			// 显示1.开户 2.销户 3.检索普通用户 4.检索已销账户 5.检索锁定账户 6.解除锁定账户 7.重置密码
			System.out.println("请选择操作:");
			adminView.showAdminFunction();

			String inputChoice = scanner.next();
			
			//1=开户
			if ("1".equals(inputChoice)) {
				while(true) {
					
					System.out.println(CommonUtils.getPropValue("T006"));
					
					String UserName = scanner.next();
					adminService.addUserName(UserName);
					
					System.out.println(CommonUtils.getPropValue("S003"));
					break;
				}
				while (true) {
					System.out.println(CommonUtils.getPropValue("T007"));
					
					String idCard = scanner.next();
					adminService.addIdCard(idCard);
					
					System.out.println(CommonUtils.getPropValue("S004"));
					break;

				}
				while (true) {
					System.out.println(CommonUtils.getPropValue("T008"));
					
					String sex = scanner.next();
					adminService.addSex(sex);
					
					System.out.println(CommonUtils.getPropValue("S005"));
					break;

				}
				while (true) {
					System.out.println(CommonUtils.getPropValue("T009"));
					
//					Date birthday = scanner.nextDate();
					adminService.addBirthday(AdminUtils.inputBirthday());
					
					System.out.println(CommonUtils.getPropValue("S006"));
					break;
					
				}
				while (true) {
					System.out.println(CommonUtils.getPropValue("T010"));
					
					String address = scanner.next();
					adminService.addAddress(address);
					
					System.out.println(CommonUtils.getPropValue("S007"));
					break;
					
				}
				
				//备注
				while (true) {

					System.out.println(CommonUtils.getPropValue("T014"));
//					System.out.println("请输入备注信息");
					
					String remark = scanner.next();
					boolean bln =adminService.addRemark(remark);
					if(bln) {
						
						System.out.println("输入备注信息成功");
						break;
					}
//					System.out.println(CommonUtils.getPropValue("S010"));
				}
				
				/**
				 * 默认余额为0.0
				 */
				double balance = 0.0;
				System.out.println("默认余额初始值为0.0");
				adminService.addBalance(balance);
				
				//生成卡号
				while (true) {
//					System.out.println(CommonUtils.getPropValue("T011"));//没打印
					System.out.println("正在生成卡号成功，你的卡号是：");
					
//					int cardNumber = scanner.nextInt();
					adminService.addCardNumber();
					
//					System.out.println(CommonUtils.getPropValue("S008"));//没打印
//					System.out.println("生成卡号成功");
//					System.out.println("+++++++++");
					break;
					
				}
				
				
				while (true) {
//					System.out.println(CommonUtils.getPropValue("T012"));
					System.out.println("请设置密码");
					
					String password = scanner.next();
					adminService.addPassWord(password);
					
//					System.out.println(CommonUtils.getPropValue("S009"));
					
					System.out.println("设置密码成功");
					break;
					
				}
				
				
				System.out.println("系统自动生成id");
				adminService.queryId();
				
				adminService.openAccount();
				System.out.println("存入数据库成功");
				
				break;
				
				//2=销户
			} else if ("2".equals(inputChoice)) {
				
				System.out.println("请选择要销户的账号：");
				String deleteCardNumber = scanner.next();
				adminService.deleteAccount(deleteCardNumber);
				break;
				
				//3=查询普通用户
			} else if ("3".equals(inputChoice)) {
				
				adminService.queryOrdinary();
				break;
				
				//4=检索已销账户
			} else if ("4".equals(inputChoice)) {
				
				adminService.queryDelete();
				break;
				
				//5=检索已锁定账户
			} else if ("5".equals(inputChoice)) {
				
				adminService.queryLock();
				break;
				
				//6=解除锁定账户
			} else if ("6".equals(inputChoice)) {
				
				System.out.println("请输入要解锁账号：");
				
				String cardnumber  = scanner.next();
				adminService.relieveLock(cardnumber);
				
				System.out.println("解除成功");
				break;
				
				//7=重置密码
			} else if ("7".equals(inputChoice)) {
				
				System.out.println("请输入要重置密码的账号和要重置的密码");
				
				String cardNumber  = scanner.next();
				String newPassword  = scanner.next();
				
				adminService.reset(cardNumber, newPassword);
				break;
				
			}else if ("8".equals(inputChoice)) {
				
				return systemController.excute(scanner);
			}
//			continue;
			adminView.showAdminFunction();
			
		}
		// return null;
		return excute(scanner);
		
	}

}
