package com.cn.comein.handle;

import com.cn.comein.base.DriverBase;
import com.cn.comein.page.LoginPage;

/** 
 * @ClassName: LoginPageHandle
 * @description: 登录页操作类
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class LoginPageHandle {
	public DriverBase driverBase;
	public LoginPage lp;
	
    public LoginPageHandle(DriverBase driverBase) {
	    this.driverBase = driverBase;
	    lp = new LoginPage(driverBase);
        }
    //填入用户名
    public void sendUserName(String userName){
    	lp.assertElement(lp.getuserNameElement());
        lp.sendKeys(lp.getuserNameElement(),userName);
    }
    //填入密码
    public void sendPassWord(String password){
    	lp.assertElement(lp.getPasswordElement());
        lp.sendKeys(lp.getPasswordElement(),password);
    }
    //点击登录按钮
    public void clickLoginButton(){
    	lp.assertElement(lp.getLoginBtnElement());
        lp.click(lp.getLoginBtnElement());
    }
    //点击自动登录按钮
    public void clickAutoLogin(){
    	lp.assertElement(lp.getAutoLoginElement());
        lp.click(lp.getAutoLoginElement());
    }
    //判断是否是登录页面
    public boolean assertLoginPage(){
		return lp.assertElement(lp.getuserNameElement());
    }
}
