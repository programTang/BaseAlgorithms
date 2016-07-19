package org.tj.bit;

/**
 * Created by 001 on 16/7/11.
 */
public class BitExample {
    public static void main(String[] args) {
        int i = 5,a = -5;
        System.out.println(Integer.toBinaryString(((int)Math.pow(2,30))   ));
        System.out.println(Integer.toBinaryString(-1));

        System.out.println((((int)Math.pow(2,31))   ));
        System.out.println(Integer.valueOf("1000000000000000000000000000000",2));
    }
}
