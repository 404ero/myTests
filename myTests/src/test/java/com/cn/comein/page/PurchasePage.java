package com.cn.comein.page;

import org.openqa.selenium.WebElement;

import com.cn.comein.base.DriverBase;
import com.cn.comein.base.PageBase;

/** 
 * @ClassName: PurchasePage
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class PurchasePage extends PageBase{

	public PurchasePage(DriverBase driverBase) {
		super(driverBase);
	}
	
	//获取购买按钮
	public WebElement getBuyButtonElement(){
		return this.getWebElement(getByElement("gobuy"));
	}
	//获取加入购物车按钮
	public WebElement getAddchartButtonElement(){
		return this.getSubLevelElement(getByElement("addChartParent"),getByElement("addChart"));
	}
	//获取购买按钮
	public WebElement getSubmitOrderButtonElement(){
		return this.getWebElement(getByElement("submitOrderButton"));
	}
	//获取购物车图标的按钮
	public WebElement getChartIconElement(){
		return this.getWebElement(getByElement("cartIcon"));
	}
	//获取购物车的弹出页的右上角课程数
	public WebElement getShoopingNumIconElement(){
		return this.getWebElement(getByElement("shoppingIcon"));
	}
	//获取购物车的弹出页的确定按钮
	public WebElement getconfirmByDivBtnElement(){
		return getSubLevelElement(getByElement("confirmByDiv"),getByElement("confirmBtn"));
	}
}
