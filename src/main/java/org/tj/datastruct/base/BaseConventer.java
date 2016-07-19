package org.tj.datastruct.base;

import org.tj.datastruct.stack.Stack;
/**
 * Created by 001 on 16/7/4.
 */
public class BaseConventer {

//    10进制转换N进制(N<10)
    public static int decimal2N(int decimal,int n){
        Stack<Integer> stack = new Stack<Integer>();
        while (decimal/n != 0){
            int a = decimal%n;
            decimal = decimal/n;
            stack.push(a);
        }

        stack.push(decimal);
//        System.out.println(stack.toString());
        return Integer.parseInt(stack.toString());
    }

//    N进制转换为10进制
    public static int n2Decimal(int number,int n){
        char[] numbers = String.valueOf(number).toCharArray();
        int sum = 0;
        int size = numbers.length-1;
        for (int i = 0;i < numbers.length;i++){
            sum += Integer.parseInt(numbers[i]+"")*Math.pow(n,size-i);
        }
        return sum;
    }

    //    N进制转换为N进制
    public static int n2N(int number,int nOri,int nTo ){
        int decimal = n2Decimal(number,nOri);
        return decimal2N(decimal,nTo);
    }

    public static void main(String[] args) {
        System.out.println(decimal2N(27,3));
        System.out.println(n2Decimal(1000, 3));
        System.out.println(n2N(1000,3,2));
    }

}
