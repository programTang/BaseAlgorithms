package org.tj.study.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

/**
 * Created by 001 on 16/8/18.
 */
public class MyException extends Exception{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyException(){

    }

    public MyException(String message){
        super(message);
    }

    public MyException(String message,Exception ex){
        super(message,ex);
    }

    static void test(int i) throws MyException {

        if (i==0){
            throw new MyException("my exception",new Exception());
        }


    }

    static void testFile() throws MyException {
        try {
            FileReader fileReader = new FileReader("F://sadas");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new MyException("ny exception",e);
        }
    }

    static int testFinally(int i){
        try {
            return i;
        }finally {
//            System.out.println(i);
            i++;
//            System.out.println(i);
        }
    }


    static MyException testFinally(MyException my){
        try {
            return my;
        }finally {
            my.setName("finally");
        }
    }


    public static void main(String[] args) {
//当函数执行到return 的时候，程序会把返回值压到堆栈中，然后把局部变量压入堆栈 这个时候堆栈中有两个相同值，finally操作的时局部变量，并不影响返回的值。
// 但是当返回值是引用类型就不一样了，程序将返回的引用压入堆栈，堆栈有两个指向同一片内存（实例对象）的引用，不管改变哪个引用，都会对实例造成变化。
//        System.out.println(testFinally(1));
//        MyException myException = new MyException();
//        myException.setName("xxx");
//        System.out.println(testFinally(myException).getName());
//        String a = "xxx";
//        String b = "xxx";
//        String a = new String("xxx");
//        String b = new String("xxx");
//        System.out.println(a==b);
//        System.out.println(a.hashCode()+"    "+b.hashCode());
//        System.out.println(a.equals(b));
        String a = new String("aaa");
        String b = "ccc";
        b = a;
        System.out.println(b==a);
//        try {
//            StringBuffer
//            testFile();
//        } catch (MyException e) {
////            e.getCause().printStackTrace();
//            e.printStackTrace();
//        }
    }
}
