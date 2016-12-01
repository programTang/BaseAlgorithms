package org.tj.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 001 on 16/9/22.
 */
public class Test {

    private int a;

    public Test(int a){
        this.a = a;
    }

    public void say(){
        System.out.println("say something");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("org.tj.study.reflect.Test");
        Method[] methods = clazz.getDeclaredMethods();
//        Constructor<Test> testConstructor = clazz.getConstructor(clazz);
//        Test test = testConstructor.newInstance(3);
        Test test = (Test) clazz.newInstance();
        System.out.println(test.a);
        System.out.println(methods[1].getName());

    }


}
