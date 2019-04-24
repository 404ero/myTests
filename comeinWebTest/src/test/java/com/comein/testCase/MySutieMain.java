package com.comein.testCase;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/** 
 * @ClassName: MySutieMain
 * @description: 
 * @author: your name
 * @Date: 2019年4月22日 下午5:25:17
 */

public class MySutieMain {
		public static Test suite() { 
			TestSuite suite = new TestSuite();
			suite.addTest(new JUnit4TestAdapter(Login.class));	//登录
			//suite.addTest(new JUnit4TestAdapter(HomePageAutoTest.class));		//首页
	        return suite;  
	} 
	
	public static void main(String args[]) { 
		TestRunner.run(suite()); 
	}

}
