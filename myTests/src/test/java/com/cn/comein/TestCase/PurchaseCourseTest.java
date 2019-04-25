package com.cn.comein.TestCase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cn.comein.base.CaseBase;
import com.cn.comein.base.DriverBase;
import com.cn.comein.business.PurchasePro;

/** 
 * @ClassName: BuyCourseTest
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class PurchaseCourseTest extends CaseBase{
	public DriverBase driverBase;
	public PurchasePro purchasePro;
	private static Logger logger = Logger.getLogger(Login.class);
	public PurchaseCourseTest() {
		this.driverBase = InitDriver("chrome");
		purchasePro = new PurchasePro(driverBase);
	}
	@Test
	public void purchaseCourseAndOrder(){
		logger.debug("debug��ӡ------------------------------");
		String url = "https://coding.imooc.com/";
		driverBase.get(url);
		driverBase.getDriver().manage().window().maximize();
		purchasePro.purchaseCourse(url);
		//purchasePro.addChartByCourse();
		System.out.println("下单成功");
	}

}
