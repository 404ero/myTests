package com.comein.testCase;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.comein.base.CommonEngine;
import com.comein.base.DriverBase;
import com.comein.base.LoginContant;
import com.comein.base.LoginKeyword;
import com.comein.utils.DataStore;
import com.comein.utils.ExcelUtil;
 

/** 
 * @ClassName: Login
 * @description: 
 * @author: your name
 * @Date: 2019骞�4鏈�22鏃� 涓嬪崍5:22:41
 */

public class Login {
	public static Logger logger = Logger.getLogger(Login.class.getName());
	public static LoginKeyword loginkeyword;
	public static String keyword;
	public static String pe;
	public static String value;
	public static boolean result;
	
	public Login () {
		loginkeyword = new LoginKeyword(new DriverBase(DataStore.startExplore));
	}
	@Test
	public void test() {
		ExcelUtil.setExcelFile(LoginContant.TextPath+LoginContant.fileName);// 加载登录文件
		DOMConfigurator.configure(DataStore.logUrl);//加载log4j文件
		result = true;
		//循环读取suitSheet里面的值，找出运行的场景
		for (int j = 1;j<=ExcelUtil.getLastRownum(LoginContant.suiteSheet);j++) {			
			// 读取suitesheet里面的runmode字段，如果为yes则执行该用例，No则不执行
			String runMode = ExcelUtil.getCellData(j, LoginContant.suiteRunmodeCol, LoginContant.suiteSheet);
			// 读取suitesheet里面的testsuiteID字段
			String suiteTestid = ExcelUtil.getCellData(j, LoginContant.suiteTestIdCol, LoginContant.suiteSheet);
			//int srownum;
			if (runMode.equals("YES")) {
				logger.log(Level.INFO, "开始执行第"+j+"条");
				// 循环遍历loginsheet里面的值，找出运行的步骤
				for (int srownum = 1;srownum<=ExcelUtil.getLastRownum(LoginContant.caseSheet);srownum++) {
					// 获取loginsheet里面的测试用例序号
					String loginTestid = ExcelUtil.getCellData(srownum, LoginContant.caseTestIdCol, LoginContant.caseSheet);
					if (loginTestid.trim().equals(suiteTestid)) { // 如果loginsheet里面的测试用例序号和suitesheet里面的用例序号一致
						// 获取loginsheet里面的测试步骤序号（和loginkeyword里面的方法对应）
						keyword = ExcelUtil.getCellData(srownum, LoginContant.caseKeywordCol, LoginContant.caseSheet);
						
						// 获取loginsheet里面的页面元素（id，xpath路径等）
						pe = ExcelUtil.getCellData(srownum, LoginContant.casePageElementCol, LoginContant.caseSheet);
						
						// 获取loginsheet里面的值（需要输入或者对比的值）
						value = ExcelUtil.getCellData(srownum, LoginContant.casePageValueCol, LoginContant.caseSheet);
						CommonEngine.Action(keyword, loginkeyword, pe, value, srownum, result);
						
						if (result == true) {// 将结果写入loginsheet
							ExcelUtil.setCellData(LoginContant.pass, srownum, LoginContant.caseResultCol, LoginContant.TextPath+LoginContant.fileName, LoginContant.caseSheet);
						} else {// 将结果写入loginsheet
							ExcelUtil.setCellData(LoginContant.fail, srownum, LoginContant.caseResultCol, LoginContant.TextPath+LoginContant.fileName, LoginContant.caseSheet);
						}
						if (result == false) {// 将结果写入suitesheet
							ExcelUtil.setCellData(LoginContant.fail, j, LoginContant.suiteResultCol, LoginContant.TextPath+LoginContant.fileName, LoginContant.suiteSheet);
							logger.log(Level.INFO, "第"+j+"条用例执行完成");
						}
					}
				}
				if (result == true) {// 将结果写入suitesheet
					ExcelUtil.setCellData(LoginContant.pass, j, LoginContant.suiteResultCol, LoginContant.TextPath+LoginContant.fileName, LoginContant.suiteSheet);
					logger.log(Level.INFO, "第"+j+"条用例执行完成");
				}
			} else {
				logger.log(Level.INFO, "没有要执行的用例");
				break;
			}
		}
	}
}
