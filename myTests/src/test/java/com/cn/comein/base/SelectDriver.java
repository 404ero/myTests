package com.cn.comein.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/** 
 * @ClassName: SelectDriver
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class SelectDriver {
	
	//封装:webDriver
	public WebDriver driverName(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			String marionette = "WebDriver.Chrome.marionette";
			String chromeDriverUrl = "D:\\chromeDriver\\chromedriver.exe";
			System.setProperty(marionette,chromeDriverUrl);
			return new ChromeDriver();
		}else{
			return null;
		}
	}

}
