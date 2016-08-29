package org.tj.algorithms.artofcoding.gcd;

/**
 * Created by 001 on 16/8/25.
 */
public class Euclidean {

//    欧几里德算法 又称辗转相除法 用来求两个数字的最大公因数
    static public int gcd(int m,int n){
        if (m<n){
            int t = m;
            m = n;
            n = t;
        }
        int k = m%n;
        while (k!=0){
            int t = n;
            n=k;
            m=t;
            k=m%n;
        }
        return n;
    }


    public static void main(String[] args) {
        System.out.println(gcd(544,119));
    }

}
