package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.BackendUser;
import pojo.DevUser;

import service.BackendUserService;
import service.DevUserService;

public class text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DevUserService bank=(DevUserService)context.getBean("devUserService");
		DevUser user=new DevUser();
		user= bank.login("test001", "123456");
		if(user!=null){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}

	}

}
