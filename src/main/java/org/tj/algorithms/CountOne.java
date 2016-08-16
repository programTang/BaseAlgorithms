package org.tj.algorithms;

/**
 * Created by 001 on 16/8/15.
 */
public class CountOne {

//    时间复杂度为i的有效长度
    static public int countOneInInt(int i){
        int count = 0;
        for (;i!=0;i=i>>1){
            if ((i&1) == 1){
                count++;
            }
        }
        return count;
    }

    static public int countOneInInt2(int i){
        int count = 0;
        for (;i!=0;i=i&(i-1))
            count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOneInInt2(8));
    }

}
