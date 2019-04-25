package com.cn.comein.page;

import org.openqa.selenium.WebElement;

import com.cn.comein.base.DriverBase;
import com.cn.comein.base.PageBase;

/** 
 * @ClassName: LoginPage
 * @description: 登录页面
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class LoginPage extends PageBase{

	public LoginPage(DriverBase driverBase) {
		super(driverBase);
	}
	//获取名字
	public WebElement getuserNameElement() {
//		assertElement(userName);
//		sendKeys(userName,"13828840324");
//		WebElement password = this.ByElemnts("password");
//		assertElement(password);
//		sendKeys(password,"yi228324");
//		WebElement loginBtn = this.ByElemnts("loginBtn");
//		click(loginBtn);
//		WebElement header = this.ByElemnts("header");
//		mouseAction(header,"click-hold");
		return this.getWebElement(getByElement("usernameElement"));
	}
	//获取密码
	public WebElement getPasswordElement() {
		return this.getWebElement(getByElement("passwordElement"));
	}
	//获取登录按钮
	public WebElement getLoginBtnElement() {
		return this.getWebElement(getByElement("loginBtn")); 
	}
	//获取自动登录按钮
	public WebElement getAutoLoginElement() {
		return this.getWebElement(getByElement("autoSignin")); 
	}

}
