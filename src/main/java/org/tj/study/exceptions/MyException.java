package org.tj.study.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by 001 on 16/8/18.
 */
public class MyException extends Exception{

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
            System.out.println(i);
            i++;
            System.out.println(i);
        }
    }


    public static void main(String[] args) {

        
//        try {
//            StringBuffer
//            testFile();
//        } catch (MyException e) {
////            e.getCause().printStackTrace();
//            e.printStackTrace();
//        }
    }
}
