package org.tj.algorithms.artofcoding.strings;

import org.tj.algorithms.strings.StringCutter;

/**
 * Created by 001 on 16/8/25.
 */
public class SpinningString {

//    定义字符串的左旋转操作:把字符串前面的若干个字符移动到字符串的尾部。
// 如把字符串 abcdef 左旋转 2 位得到字符串 cdefab。 请实现字符串左旋转的函数,要求对长度为 n 的字符串操作的时间复杂度为 O(n),



//    设计一个算法,把一个含有 N 个元素的数组循环右移 K 位,要求时间复杂度为 O(N), 且只允许使用两个附加变量。
//    最直接解法 一位一位移  每移一位整个数组变动一次  先吧最后一位保存  然后每一位往前移一位
//    时间复杂度为 n * (k%n)
    public static char[] rightShift(char[] n,int k){
        int length = n.length;
        k = k%length;
        k = k>0?k:length+k;
        for (int i=0;i<k;i++){
            char tmp = n[length-1];
            for (int j=length-1;j>0;j--){
                n[j] = n[j-1];
            }
            n[0] = tmp;
        }
        return n;
    }

//   abcf1234 右移四位变成1234abcf  那么直接吧后四位放倒字符串前面即可 时间复杂度n
    public  static char[] rightShift2(char[] n,int k){
        int length = n.length;
        k = k%length;
        k = k>0?k:length+k;
//        k=length-k;
//        构建一个新的char[]；
        char[] m = new char[length];
        for (int i=0;i<k;i++){
            m[i] = n[length-k+i];
        }
        for (int i=k;i<length;i++){
            m[i] = n[i-k];
        }
        return m;
    }

//   abcf1234 右移3位 先把前五位倒序 1fcba 后三位倒序432  再整个倒序 234abcf1
    public static char[] rightShift3(char[] n,int k){
        int length = n.length;
        k = k%length;
        k = k>0?k:length+k;
        for (int i=0;i<=(length-k-1)/2;i++){
            char tmp = n[i];
            n[i] = n[length-k-i-1];
            n[length-k-i-1] = tmp;
        }
//        System.out.println(String.valueOf(n));
        for (int i=length-k;i<=(2*length-k-1)/2;i++){
            char tmp = n[i];
            n[i] = n[length+(length-k)-1-i];
            n[length+(length-k)-1-i] = tmp;
        }
//        System.out.println(String.valueOf(n));

//      反正n
        for (int i=0;i<=(length-1)/2;i++){
            char tmp = n[i];
            n[i] = n[length-1-i];
            n[length-1-i] = tmp;
        }
        return n;
    }


    public static void main(String[] args) {
        String s = "abcf1234";
        System.out.println(String.valueOf(rightShift(s.toCharArray(),-13)));
        System.out.println(String.valueOf(rightShift2(s.toCharArray(), -13)));
        System.out.println(String.valueOf(rightShift3(s.toCharArray(), -13)));
    }


}
