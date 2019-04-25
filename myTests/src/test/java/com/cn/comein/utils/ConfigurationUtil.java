package com.cn.comein.utils;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: ConfigurationUtil
 * @description: 
 * @author: your name
 * @Date: 2019年4月18日 上午10:57:43
 */

public class ConfigurationUtil {
	
	public List<String> Configuration(String key,String FileUrl,String splitType){
		List<String> list=new ArrayList<String>();
		ProUtil properties = new ProUtil(FileUrl);
		String value = properties.getPro(key);
		System.out.println(value);
		if(splitType.isEmpty()){
			list.add(value);
			return list;
		}else{
			String localType = value.split(splitType)[0];
			System.out.println(localType);
			String localvalue = value.split(splitType)[1];
			System.out.println(localvalue);
			list.add(localType);
			list.add(localvalue);
			return list;
		}
	}
	

}
