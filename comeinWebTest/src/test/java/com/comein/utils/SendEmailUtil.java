package com.comein.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/** 
 * @ClassName: SendMailUtil
 * @description: 发送邮件Util
 * @author: Yong Chen
 * @Date: 2019年4月18日 上午10:57:43
 */

public class SendEmailUtil {
	public static void sendToEmail(){
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.qq.com");
		email.setAuthentication("328883914@qq.com", "pmcuuggwaicjcaia");
		try {
			email.setFrom("328883914@qq.com");
			email.addTo("327467421@qq.com");
			email.setSubject("selenium�Զ��������ʼ�");
			email.setContent("���Ƿ��͵Ĳ����ʼ�","text/html;charset=utf-8");
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		sendToEmail();
	}
}
