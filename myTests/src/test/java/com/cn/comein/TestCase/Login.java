package com.cn.comein.TestCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cn.comein.base.CaseBase;
import com.cn.comein.base.DriverBase;
import com.cn.comein.business.LoginPro;

/** 
 * @ClassName: Login
 * @description: 
 * @author: your name
 * @Date: 2019年4月10日上午11:41:08
 */

public class Login extends CaseBase{
	public DriverBase driverBase;
	public LoginPro loginPro;
	private static Logger logger = Logger.getLogger(Login.class);
	public Login() {
		this.driverBase = InitDriver("chrome");
		loginPro = new LoginPro(driverBase);
	}
	
	@Test
	public void loginHome(){
		driverBase.get("https://www.imooc.com/");
		loginPro.lph.lp.getWebElement(By.id("js-signin-btn")).click();
		driverBase.sleep();
	}
	
	@Test(dependsOnMethods={"loginHome"})
	public void testLogin(){
		logger.debug("debug打印。");
		loginPro.login("13828840324", "yi228324");
	}

}
