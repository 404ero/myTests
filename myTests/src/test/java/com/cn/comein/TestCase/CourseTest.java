package com.cn.comein.TestCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cn.comein.base.CaseBase;
import com.cn.comein.base.DriverBase;
import com.cn.comein.base.PageBase;

/** 
 * @ClassName: CourseTest
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class CourseTest extends CaseBase{
	public DriverBase driverBase;
	public PageBase pb;
	public CourseTest() {
		this.driverBase = InitDriver("chrome");
		this.pb = new PageBase(driverBase);
	}
	@Test
	public void CourseList(){
		driverBase.get("https://coding.imooc.com/");
		driverBase.getDriver().manage().window().maximize();
		List<String> listStrings = this.getListElement();
		for(int i = 0;i<listStrings.size();i++){
			String s = listStrings.get(i).substring(24);
			WebElement element = pb.getWebElement(By.xpath("//a[@href='"+s+"']"));
			pb.pullDownList(element);
			driverBase.back();
		}
	}
	//获取课程的List
	public List<String> getListElement(){
		List<String> listStrings = new ArrayList<String>();
		WebElement element = pb.getWebElement(By.className("shizhan-course-list"));
		List<WebElement> listElements = element.findElements(By.className("shizhan-course-wrap"));
		for(WebElement ele:listElements){
			listStrings.add(ele.findElement(By.tagName("a")).getAttribute("href"));
		}
		return listStrings;
	}
}
