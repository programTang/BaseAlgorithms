package org.tj.algorithms.strings;

import java.io.UnsupportedEncodingException;

/**
 * Created by 001 on 16/8/18.
 */
public class StringCutter {
//  编写一个截取字符串的函数,输入为一个字符串和字节数,输出为按字节截 取的字符串,但要保证汉字不被截取半个,
// 如“我 ABC”,4,应该截取“我 AB”, 输入“我 ABC 汉 DEF”,6,应该输出“我 ABC”,而不是“我 ABC+汉的半个”。
//    很明显   占两个字节的不能分开 要当作整体 及大于2的8次方的
    static String cuttingString(String a,int n){
        char[] chars = a.toCharArray();
        int i = 0;
        StringBuilder s = new StringBuilder();
        while (n>0){
            char c = chars[i];
            if ((int)c > 128){
                n = n -2;
                if (n<0){
                    break;
                }
            }else {
                n--;
            }
            s.append(chars[i++]);
        }

//        for (int i=0;i<)
        return s.toString();
    }

    public static int trimGBK(byte[] buf,int n){
        int num = 0;
        boolean bChineseFirstHalf = false;
        System.out.println(buf.length);
        for(int i=0;i<n;i++){
            System.out.println(buf[i]);
            if(buf[i]<0&& !bChineseFirstHalf){
                bChineseFirstHalf= true;
            }else{
                num++;
                bChineseFirstHalf= false; }
        }
        return num; }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "我ADC汉DEF";
//        System.out.println(cuttingString(s, 7));
//        System.out.println(trimGBK(s.getBytes("GBK"),10));
        System.out.println(Integer.toBinaryString(5));
    }
}
