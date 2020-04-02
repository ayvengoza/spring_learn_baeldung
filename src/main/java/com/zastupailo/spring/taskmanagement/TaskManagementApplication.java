package com.zastupailo.spring.taskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TaskManagementApplication {
	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(TaskManagementApplication.class, args);
//		displayAllBeans();
	}

	public static void displayAllBeans() {
		String[] allBeansName = applicationContext.getBeanDefinitionNames();
		for (String beanName : allBeansName) {
			System.out.println(beanName);
		}
	}

}
