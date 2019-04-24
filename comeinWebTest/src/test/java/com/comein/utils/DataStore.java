package com.comein.utils;
import com.comein.utils.PropertiesFile;

/** 
 * @ClassName: DataStore
 * @description: 
 * @author: your name
 * @Date: 2019年4月22日 下午4:55:46
 */

public class DataStore {
	    // 驱动路径
		public static String driverurl = PropertiesFile.read("driverurl");
		public static String key = PropertiesFile.read("key");
		public static String startExplore = PropertiesFile.read("startExplore");
		public static String logUrl = PropertiesFile.read("log4jUrl");
		public static String configFileUrl = PropertiesFile.read("configFileUrl");
		public static void main(String[] args) {
			System.out.println(driverurl);
			System.out.println(startExplore);
		}
}
