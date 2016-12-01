package org.tj.study.oop;

/**
 * Created by 001 on 16/8/5.
 */
public class Cat extends Animal{
    @Override
    public void breathe() {
        System.out.println("cat miaomiao");
    }

    public void run(){
        System.out.println("cat running");
    }

}
