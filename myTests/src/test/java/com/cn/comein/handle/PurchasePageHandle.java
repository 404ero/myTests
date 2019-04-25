package com.cn.comein.handle;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cn.comein.base.DriverBase;
import com.cn.comein.page.PurchasePage;

/** 
 * @ClassName: PurchasePageHandle
 * @description: 购买操作类
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class PurchasePageHandle {
	public DriverBase driverBase;
	public PurchasePage pp;
	public PurchasePageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		pp = new PurchasePage(driverBase);
	}
	
	//点击购买按钮
    public void clickBuyCourseButton(){
    	pp.click(pp.getBuyButtonElement());
    }
    
    //点击加入购物车
    public void clickAddchartButton(){
    	pp.assertElement(pp.getAddchartButtonElement());
    	pp.click(pp.getAddchartButtonElement());
    }
    
    //点击提交订单按钮
    public void clickSubmitOrderButton(){
    	pp.assertElement(pp.getSubmitOrderButtonElement());
    	pp.click(pp.getSubmitOrderButtonElement());
    }
   //鼠标移动到购物车图标上
    public void mouseMoveonChartIcon(){
    	pp.assertElement(pp.getChartIconElement());
    	pp.mouseAction(pp.getChartIconElement(), "click-hold");
    }
    
    //获取购物车弹出页右上角的课程数
    public String getShoppingNum(){
    	pp.assertElement(pp.getShoopingNumIconElement());
    	return pp.getShoopingNumIconElement().getAttribute("data-cartnum");
    }
    
	//获取订单页面的课程名称
	public String getOrderCourseName(){
		return pp.getWebElement(pp.getByElement("orderCourseName")).getText();
	}
	
	//获取购买页面的课程名
	public String getPurchaseCourseName(){
		return pp.getWebElement(pp.getByElement("purchaseCourseName")).getText();
	}
	
	//获取购物车的课程数
	public String getIncartCourseNum(){
		return pp.getWebElement(pp.getByElement("incartCourseNum")).getText();
	}
	//获取订单号
	public String getOrderNum(){
		return pp.getWebElement(pp.getByElement("orderNum")).getText();
	}
    
	//点击购物车弹出页的确定按钮
    public void clickconfirmByDivBtnElement(){
    	pp.assertElement(pp.getconfirmByDivBtnElement());
    	pp.click(pp.getconfirmByDivBtnElement());
    }
    //判断是购买页
    public boolean assertPurchasePage(){
		return pp.assertElement(pp.getBuyButtonElement());
    }
    
	//获取课程的List
	public List<String> getListElement(){
		List<String> listStrings = new ArrayList<String>();
		WebElement element = pp.getWebElement(By.className("shizhan-course-list"));
		List<WebElement> listElements = element.findElements(By.className("shizhan-course-wrap"));
		for(WebElement ele:listElements){
			listStrings.add(ele.findElement(By.tagName("a")).getAttribute("href"));
		}
		return listStrings;
	}
}
