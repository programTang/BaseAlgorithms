package org.tj.datastruct;

/**
 * Created by 001 on 16/6/30.
 */

//打印int
public class PrintInt {

    public static void main(String[] args) {
        printInt(123);
    }

    public static void printInt(long a){
        if (a>=10)
            printInt(a/10);
        System.out.print(a%10);
    }


    public static void printDouble(double a){

    }
//    public static void printInt(long a){
//        if (a>=10){
//            printInt(a/10);
//        }else {
//            System.out.print(a%10);
//            return;
//        }
//    }

}
