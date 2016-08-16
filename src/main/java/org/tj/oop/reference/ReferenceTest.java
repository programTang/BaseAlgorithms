package org.tj.oop.reference;

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

    public static void main(String[] args) {
        ReferenceTest referenceTest = new ReferenceTest("bbbb");
        test(referenceTest);
        System.out.println(referenceTest.getName());

    }
}
