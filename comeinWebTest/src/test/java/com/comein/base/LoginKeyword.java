package com.comein.base;

import org.openqa.selenium.WebElement;

import com.comein.base.DriverBase;
import com.comein.testCase.Login;
import com.comein.utils.Log;

/** 
 * @ClassName: LoginKeyword
 * @description: 
 * @author: your name
 * @Date: 2019年4月22日 下午4:53:06
 */

public class LoginKeyword extends PageBase{
	public LoginKeyword(DriverBase driverBase) {
		super(driverBase);
	}
	/**
	 *  打开浏览器输入网址
	 */
	public  void OpenBrowserSetUrl(String url) {
		try {
			Log.info("正在打开网址： "+ url);
			driverBase.get(url);
		} catch (Exception e) {
			Log.error("无法打开当前网址----- " + e.getMessage());
			Login.result = false;
		}
	}
	
	/**
	 *  输入值
	 * @param pe 页面元素
	 * @param value 输入的值
	 */
	public  void Input(String pe,String value) {
		try {
			Log.info("在该元素： "+ pe+"位置输入的值为:"+value);
			WebElement el = getWebElement(getByElement(pe));
			el.clear();
			el.sendKeys(value);
		} catch (Exception e) {
			Log.error("无法输入元素的值----- " + e.getMessage());
			Login.result = false;
		}
	}
	/**
	 *  点击登录
	 * @param pe 页面元素
	 */
	public  void Click(String pe) {
		try {
			Log.info("点击元素： "+ pe);
			getWebElement(getByElement(pe)).click();
		} catch (Exception e) {
			Log.error("无法点击元素--- " + e.getMessage());
			Login.result = false;
		}
	}
	
	/**
	 *  关闭浏览器
	 */
	public  void CloseBrowser() {
		try {
			Log.info("浏览器正在关闭：---------------------------");
			driverBase.close();
		} catch (Exception e) {
			Log.error("关闭浏览器失败--- " + e.getMessage());
			Login.result = false;
		}
	}
	/**
	 *  等待时间
	 */
	public  void Sleep() {
		try {
			Log.info("等待一会儿，精彩马上回来：---------------------------");
			driverBase.sleep();
		} catch (Exception e) {
			Log.error("抱歉,等待途中出问题了---------" + e.getMessage());
			Login.result = false;
		}
	}
}
