package org.tj.algorithms.nod;

import org.tj.datastruct.stack.Stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 001 on 16/7/11.
 */
public class Nod1083 {
//    public static void main(String[] args) {
//        String a = "1234";
//        Stack<String> stack = new Stack<>();
//        stack.push(a.substring(0,1));
//        for (int i=1;i<a.length();i++){
//            String insert = getIndex(a,i+1);
//            Set<String> set = new HashSet<>();
//            while (stack.getSize() != 0){
//                String t = stack.pop();
//                for (int j=0;j<i;j++){
//                    set.add(insertIndex(t,insert,j));
//                }
//            }
//            for (String s:set){
//                stack.push(s);
//            }
//        }
//        while (stack.getSize()!=0){
//            System.out.println(stack.pop());
//        }
//    }
//
//        public static void main(String[] args) {
//     /* * 循环连续输入和输出 * 输入：一个数字 3 * 一个数组 1 2 3 */
//            Scanner x=new Scanner(System.in);
//            int[] number = new int[10];
//
//
//            while(x.hasNext()){
//                int m=x.nextInt();
//                //System.out.println(m);
//                int[] number=new int[m];
//                for(int i=0;i<m;i++){
//                    number[i]=x.nextInt();
//                }
//                // Arrays.sort(number);
//                System.out.println(Arrays.toString(number));
//            }
//        }


    static String getIndex(String a,int n){
        return a.substring(n-1,n);
    }
    static String insertIndex(String a,String insert,int n){
        return a.substring(0,n)+insert+a.substring(n);
    }
}
