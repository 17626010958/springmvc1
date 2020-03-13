package com.lpp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lpp.spring.dao.EmpDao;
import com.lpp.spring.service.EmpService;
import com.lpp.spring.service.ExamService;
 
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("spring IOC 容器初始化成功");
		//
		//注解的bean的ID在默认情况下为类名首字母小写
		
		EmpService empservice = (EmpService)ctx.getBean("empService");
		empservice.entry();
		 
		 
		ExamService examservice = (ExamService)ctx.getBean("examService");
		examservice.attendence();
		
	}

}
