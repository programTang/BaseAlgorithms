package org.tj.algorithms.hash;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by 001 on 16/8/25.
 */
public class DemoHash {

//    随机生成n个数的数组
    public static int[] randIntArray(int n){
        Random random = new Random();
        int []array = new int[n];
        for (int i=0;i<n;i++){
            array[i] = random.nextInt();
        }
        return array;
    }
//    直接对n取模算hash
    public static int[] modhash(int[] array,int n){
        int[] array1 = new int[16];
        int length = array.length;
        for (int i=0;i<length;i++){
            int index = array[i]%n;
            array1[index>0?index:-index]++;
        }
        return array1;
    }

    //    斐波那契（Fibonacci）散列法
    public static int[] fibonaccihash(int[] array,int n){
        int[] array1 = new int[16];
        int length = array.length;
        long f = Long.valueOf("2654435769");
        for (int i=0;i<length;i++){
            int index = (int) ((array[i]*f)%n);
            array1[index>0?index:-index]++;
        }
        return array1;
    }

    public static void printArray(int[] array){
        int length = array.length;

        for (int i=0;i<length;i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }



    public static void main(String[] args) {

//        System.out.println(-5%4);
        int [] array = randIntArray(16);
        printArray(modhash(array,16));
        printArray(fibonaccihash(array,16));
//        long k = Long.valueOf("2654435769");
//        for (long i =0;i<100;i++){
//            System.out.println(((i*k)>>28) %16);
//        }
    }
}
