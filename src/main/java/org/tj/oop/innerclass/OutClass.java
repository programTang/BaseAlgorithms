package org.tj.oop.innerclass;

/**
 * Created by 001 on 16/8/18.
 */
public class OutClass {

    private String name = "out-private";
    static protected String name2 = "out-protected";
    public String name3 = "out-public";

    static class InnerClass{
        static private String a;
        public InnerClass(){

        }
    }

    public static void main(String[] args) {
        char a ;
        a = 0;
        while (a<=1000){
            System.out.println(a++);
        }

//        System.out.println(a);
    }
}
