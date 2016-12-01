package org.tj.algorithms.nod;

import java.io.*;
import java.util.Scanner;

/**
 * Created by 001 on 16/7/5.
 */
public class Nod1059 {

    /**
     * 求N的阶乘 * * @param n * 0&lt;=n&lt;=100000
     */
    public static void fun(int n) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        long[] a = new long[1000000];
        int carry, j;
        //        位数
        int digit = 1;
        int temp, i;
        a[0] = 1;
        for (i = 2; i <= n; i++) {
            System.out.println(digit);

            for (carry = 0, j = 1; j <= digit; ++j) {
                //计算乘积
                temp = (int) (a[j - 1] * i + carry);
                //保存每一位
                a[ j - 1]=temp % 10;
                //进位
                carry = temp / 10;
            }
            while ( carry > 0){
//                digit++;
                a[++digit - 1] = carry % 10;
                //保存高位
                carry/=10;
            }
        }
//        System.out.println(digit);
        for (int k = digit,c = 999; k >=1;--k,--c){
            writer.write(a[k-1]+"");
            if (c == 0){
                c=1000;
                writer.write("\r\n");
            }
//            System.out.println(a[k - 1]);
        }
//        System.out.println();
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);

//        int n = Integer.parseInt(reader.readLine());
        int n = in.nextInt();
//        fun(n);
        long[] a = new long[1000000];
        int carry, j;
        //        位数
        int digit = 1;
        int temp, i;
        a[0] = 1;
        for (i = 2; i <= n; i++) {
//            System.out.println(digit);

            for (carry = 0, j = 1; j <= digit; ++j) {
                //计算乘积
                temp = (int) (a[j - 1] * i + carry);
                //保存每一位
                a[ j - 1]=temp % 10;
                //进位
                carry = temp / 10;
            }
            while ( carry > 0){
//                digit++;
                a[++digit - 1] = carry % 10;
                //保存高位
                carry/=10;
            }
        }
//        System.out.println(digit);
        for (int k = digit,c = 999; k >=1;--k,--c){
//            writer.write(a[k-1]+"");
            out.print(a[k-1]);
            if (c == 0){
                c=1000;
                out.println();
            }
//            System.out.println(a[k - 1]);
        }
//        int i = 1000;
//        while (i>0){
//            System.out.println(i=i>>1);
//        }
    }

}

