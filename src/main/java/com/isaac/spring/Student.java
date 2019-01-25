package com.isaac.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 13:42 2018/10/22
 */
public class Student  implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private String address;
    private int age;


    private BeanFactory beanFactory;
    private String beanName;

    public Student() {
        System.out.println("调用构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("注入属性address");
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("注入属性age");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[BeanFactoryAware接口]调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[BeanNameAware接口]调用BeanNameAware.setBeanName()");
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean接口]调用InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[DiposibleBean接口]调用DiposibleBean.destory()");
    }

    public void myInit() {
        System.out.println("[init-method]调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestory() {
        System.out.println("[destroy-method]调用<bean>的destroy-method属性指定的初始化方法");
    }
}
