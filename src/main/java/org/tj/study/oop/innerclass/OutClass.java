package org.tj.study.oop.innerclass;

import org.tj.study.thread.ticket.one.ThreadA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by 001 on 16/8/18.
 */
public class OutClass {

    private String name = "out-private";
    static protected String name2 = "out-protected";
    public String name3 = "out-public";

    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    private class InnerClass{
        String a = "a";
        public InnerClass(){

        }
    }

    public void test(){
//        new InnerClass().a
    }

    abstract class Contents{
        abstract void eat();
    }

    public Contents getContents(){
        return new Contents(){
            @Override
            void eat() {
                System.out.println("this is a anonymous class method");
            }
        };
    }


    public static void main(String[] args) {
        InnerClass innerClass = new OutClass().getInnerClass();
        Contents contents = new OutClass().getContents();
        contents.eat();
        Thread thread = new Thread(){
            public void run() {
                System.out.println("xixixi");
            }
        };
//
//        try{
//            System.out.println("");
//        }catch (StackOverflowError e){
//
//        }
//        Stack
        thread.start();
    }
}
