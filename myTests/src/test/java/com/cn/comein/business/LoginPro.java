package com.cn.comein.business;

import com.cn.comein.base.DriverBase;
import com.cn.comein.handle.LoginPageHandle;

/** 
 * @ClassName: LoginPro
 * @description:登录业务类
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class LoginPro {
	public LoginPageHandle lph;
	public LoginPro(DriverBase driverBase) {
		lph = new LoginPageHandle(driverBase);
	}
	public void login(String userName,String password) {
		if(lph.assertLoginPage()){
			lph.sendUserName(userName);
			lph.sendPassWord(password);
			if(!lph.lp.getAutoLoginElement().isSelected()){
				lph.clickAutoLogin();
			}
			lph.clickLoginButton();
		}else{
			System.out.println("登录失败!");
		}
	}
}
