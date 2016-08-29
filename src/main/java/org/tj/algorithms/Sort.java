package org.tj.algorithms;

import java.util.*;

/**
 * Created by 001 on 16/8/16.
 */
public class Sort {

//    插入排序
//    直接插入排序
    public static void straightInsertionSort(int []a){
        int length = a.length;
        for (int i=1;i<length;i++){
            if (a[i]<a[i-1]){

            }
        }
    }


    static void quickSort(int [] a){
        quickSort(a,0,a.length-1);
    }
//    快排  平均时间复杂度 NlogN 最坏情况n2
    static void quickSort(int [] a,int begin,int end){
        int tmp = a[begin];
        int i = begin,j = end;

        if (begin<end){
            while (begin<end){
                while (begin<end && tmp<=a[end]){
                    end--;
                }
                a[begin] = a[end];

                while (begin<end && tmp>a[begin]){
                    begin++;
                }
                a[end] = a[begin];
            }
            a[begin] = tmp;
            quickSort(a,i,begin-1);
            quickSort(a,end+1,j);
        }
    }





    static void printArray(int a[]){
        int j = a.length;
        for (int i=0;i<j;i++){
            System.out.print(" "+a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {32,13,4,3,63,7,52,3,47};
//        quickSort(a);
//        straightInsertionSort(a);
//        printArray(a);

        List<Integer> list = new ArrayList<>();
        for (int i=1;i<30;i++){
            list.add(i);
        }
        Collections.shuffle(list);
        for (int j=0;j<5;j++){
            System.out.print(list.get(j)+" ");
        }
//        for (Object object : set.toArray()){
//            System.out.println((Integer)object);
//        }

    }
}
