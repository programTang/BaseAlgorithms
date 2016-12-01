package org.tj.study.oop.reference;

import java.sql.Ref;

/**
 * Created by 001 on 16/8/16.
 */
public class ReferenceTest {

    private String name;


    public ReferenceTest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static void test(ReferenceTest referenceTest){
//        referenceTest.setName("aaaa");
        referenceTest = new ReferenceTest("aaaa");
    }

    static void changeString(String a){
        a = "changeString";
    }

    static void changeStringBuilder(StringBuilder stringBuilder){
        stringBuilder.append("changeStringBuilder");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ReferenceTest referenceTest = new ReferenceTest("bbbb");
        test(referenceTest);
        System.out.println(referenceTest.getName());

        String a = new String("xx");
        changeString(a);
        System.out.println(a);
        StringBuilder stringBuilder = new StringBuilder("xx1");
        changeStringBuilder(stringBuilder);
        System.out.println(stringBuilder);
//        Class clazz = Class.forName("org.tj.oop.refernce.RefernceTest");
        Class clazz = ReferenceTest.class;
//        clazz.

    }
}
