package com.isaac.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:26 2018/10/22
 */
public class BeanLifeCycle {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");

        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Student person = factory.getBean("person",Student.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
