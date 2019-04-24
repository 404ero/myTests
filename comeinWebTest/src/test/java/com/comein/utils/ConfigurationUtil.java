package com.comein.utils;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: ConfigurationUtil
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class ConfigurationUtil {
	
	public List<String> Configuration(String pe,String splitType){
		List<String> list=new ArrayList<String>();
		System.out.println(pe);
		if(splitType.isEmpty()){
			list.add(pe);
			return list;
		}else{
			String localType = pe.split(splitType)[0];
			System.out.println(localType);
			String localvalue = pe.split(splitType)[1];
			System.out.println(localvalue);
			list.add(localType);
			list.add(localvalue);
			return list;
		}
	}
	

}
