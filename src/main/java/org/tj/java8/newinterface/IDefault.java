package org.tj.java8.newinterface;

/**
 * Created by 001 on 16/8/17.
 */
public interface IDefault {

    default void method1(){
        System.out.println("this is method1 in origin");
    }
    void method2();

    static void method3(){
        System.out.println("this is method3 in origin");
    }
}

class DefaultImp1 implements  IDefault{

    @Override
    public void method2() {
        System.out.println("this is the method2 in default1");
    }
}

class DefaultImp2 implements IDefault{

    @Override
    public void method1() {
        System.out.println("this is method1 in default2");
    }

    @Override
    public void method2() {
        System.out.println("this is method2 in default1");
    }
}

class Test{
    public static void main(String[] args) {
        IDefault iDefault1 = new DefaultImp1();
        iDefault1.method1();
        IDefault.method3();
        IDefault iDefault2 = new DefaultImp2();
        iDefault2.method1();
    }
}