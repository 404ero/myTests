package com.cn.comein.base;  
 
/** 
 * @ClassName: CaseBase
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class CaseBase {
	public DriverBase InitDriver(String browser){
		return new DriverBase(browser);
	}

}
