package com.comein.utils;

import org.apache.log4j.Logger;

/** 
 * @ClassName: Log
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class Log {
	private static Logger log = Logger.getLogger(Log.class.getName());
	public static void startTestCase(String testCaseName){
		log.info("----------------             \""+testCaseName
				+ "\"开始执行                   ----------------------");
	}
	public static void endTestCase(String testCaseName){
		log.info("----------------             \""+testCaseName
				+ "\"测试结束                   ----------------------");
	}
	public static void info(String message){
		log.info(message);
	}
	public static void error(String message){
		log.error(message);
	}
	public static void debug(String message){
		log.debug(message);
	}

}
