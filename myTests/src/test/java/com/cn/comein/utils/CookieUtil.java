package com.cn.comein.utils;

import java.util.Set;

import org.openqa.selenium.Cookie;

import com.cn.comein.base.DriverBase;

/** 
 * @ClassName: CookieUtil
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class CookieUtil {
	public DriverBase driverBase;
	public ProUtil pro;
	
	public CookieUtil(DriverBase driverBase) {
		this.driverBase = driverBase;
		pro = new ProUtil("cookie.properties");
	}
	
	public void setCookie(){
		String value = pro.getPro("apsid");
		Cookie cookie = new Cookie("apsid",value,"imooc.com","/",null);
		driverBase.setCookie(cookie);
	}
	//获取cookie
	public void writeCookie(){
		Set<Cookie> cookies = driverBase.getCookie();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("apsid")){
				pro.writePro(cookie.getName(), cookie.getValue());
			}
		}
	}

}
