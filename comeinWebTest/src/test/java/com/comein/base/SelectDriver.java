package com.comein.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comein.utils.DataStore;

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
			System.setProperty(DataStore.key,DataStore.driverurl);
			return new ChromeDriver();
		}else{
			return null;
		}
	}

}
