package org.tj.spring.helloworld;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 001 on 16/8/9.
 */
public class HWMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("helloworld.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloworld");
        helloWorld.getMessage();
        helloWorld.setMessage("ttttjjj");

        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloworld");
        helloWorld1.getMessage();

    }
}
