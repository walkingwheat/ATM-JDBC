package com.feicui.atm;

import java.util.Scanner;

import com.feicui.atm.controller.BaseController;
import com.feicui.atm.controller.SystemController;
import com.feicui.atm.utils.CommonUtils;

public class ServiceMain {

	public static void main(String[] args) {

		ServiceMain serviceMain = new ServiceMain();
		serviceMain.runService();
	}

	/**
	 * 运行业务
	 */
	public void runService() {

		// 定义人机交互的对象
		Scanner scanner = new Scanner(System.in);

		// 实例化SystemController对象，根据system字符串选择管理员登录或者普通用户登录
		BaseController controller = (BaseController) CommonUtils.getObjectFromProp("system");
		String result = controller.excute(scanner);

		controller = (BaseController) CommonUtils.getObjectFromProp(result);
		result = controller.excute(scanner);
		scanner.close();

	}
}
