package com.cn.comein.business;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cn.comein.base.DriverBase;
import com.cn.comein.handle.PurchasePageHandle;

/** 
 * @ClassName: PurchasePro
 * @description: 购买业务类
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class PurchasePro {
	public DriverBase driverBase;
	public PurchasePageHandle pph;
	public PurchasePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		pph = new PurchasePageHandle(driverBase);
	}
	public void purchaseCourse(String url){
		String purchaseCourseName ="";
		List<String> listStrings = pph.getListElement();
		for(int i = 0;i<1;i++){//listStrings.size()
			String s = listStrings.get(0).substring(24);
			WebElement element = pph.pp.getWebElement(By.xpath("//a[@href='"+s+"']"));
			pph.pp.pullDownList(element);
			if(pph.assertPurchasePage()){
				purchaseCourseName = pph.getPurchaseCourseName();
		    	pph.clickBuyCourseButton();
		    	driverBase.sleep();
		    	if(pph.pp.isElementExist("loginBtn_",2)){
		    		LoginPro lg = new LoginPro(driverBase);
		    		lg.login(pph.pp.getInfoByUtil("loginName"), pph.pp.getInfoByUtil("password"));
		    		driverBase.sleep();
		    		//pph.clickBuyCourseButton();
		    		addChartByCourse();
		    	};
		      /*pph.clickSubmitOrderButton();
		    	driverBase.sleep();
		    	Assert.assertEquals(purchaseCourseName,pph.getOrderCourseName(),"购买的课程名称不一致");
		    	Assert.assertNull(pph.getOrderNum(), "订单号不存在!");*/
			}else{
				System.out.println("下单失败!");
			}
			//driverBase.backToUrl(url);
		}
	}
	public void addChartByCourse(){
		pph.clickAddchartButton();
		//driverBase.switchToModel();
		pph.clickconfirmByDivBtnElement();
		//System.out.println("课程数"+pph.getShoppingNum());
		//pph.mouseMoveonChartIcon();
		//Assert.assertNotEquals(pph.getIncartCourseNum(), "0","购物车课程数不为0");
		
	}
}
