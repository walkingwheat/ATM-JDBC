package com.feicui.atm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * 工具类
 * 
 * @author 行走的麦子
 *
 */
public class CommonUtils {

	// public static void main(String[] args) {
	// System.out.println(CommonUtils.getPropValue("T014"));
	// }
	/**
	 * 根据键获取配置文件中对应的值
	 * 
	 * @param key
	 *            键字符串
	 * @return
	 */
	public static String getPropValue(String key) {

		// 得到键的路径(固定写法)
		InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream("infor.properties");

		// FileInputStream is = new FileInputStream(new File("infor.properties"));
		Properties prop = new Properties();

		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

	/**
	 * 根据key读取infor.properties文件中的反射配置的部分 获取类的字符串 返回对象
	 * 
	 * @param key
	 * @return
	 */
	public static Object getObjectFromProp(String key) {

		String className = getPropValue(key);
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;

	}

	/**
	 * 打印对应文本文件里的内容
	 * 
	 * @param fileName
	 */
	public static void printText(String fileName) {

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			is = CommonUtils.class.getClassLoader().getResourceAsStream(fileName);

			isr = new InputStreamReader(is);

			br = new BufferedReader(isr);

			String strLine = null;
			while ((strLine = br.readLine()) != null) {

				System.out.println(strLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 格式化时间的方法
	public static String formatUtil(String timeType, Object obj) {

		SimpleDateFormat format = new SimpleDateFormat(timeType);
		String date = format.format(obj);

		return date;
	}
}
