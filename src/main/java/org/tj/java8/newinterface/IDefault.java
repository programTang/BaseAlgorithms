package org.tj.java8.newinterface;

/**
 * Created by 001 on 16/8/17.
 */
public interface IDefault {

    default void method1(){
        System.out.println("this is method1");
    }
    void method2();
}

class Default