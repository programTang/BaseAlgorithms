package org.tj.study.oop;

/**
 * Created by 001 on 16/7/27.
 */
public abstract class Animal {

    {
        System.out.println("加载静态快");
    }
    protected int age;

    public void breathe(){
        System.out.println("Animal breathe");
    }
}
