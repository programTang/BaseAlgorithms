package org.tj.algorithms.sort;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 001 on 16/8/17.
 */
public class SonCollections {
//    用递归和循环输出子集

    public static void recursionSons(Set<String> set,char[] a,int index){
        if (index == 26){
            return;
        }else {
            char v = a[index];
            Set<String> set1 = set.stream().map(ch -> ch + v).collect(Collectors.toSet());
//            for(String v:set1){
//                set1.add(v+char[index])
//            }
            set1.forEach(b-> System.out.println(b));
//            for (String b:set1){
//                sout
//            }
            set.addAll(set1);
            recursionSons(set,a,++index);
        }
    }

//    public static Set<byte[]>

    public static void main(String[] args) {
        char[] a = {'a','b','c','d','e','f','g',
                'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Set<String> set = new HashSet<>();
        set.add("");
//        recursionSons(set,a,0);

//        System.out.println(set.size()-1);
//        System.out.println(Math.pow(2,26)-1);
        Set<byte[]> bytes = new HashSet<>();
        byte[] bytes1 = new byte[10];
        bytes1[0] = 23;
        System.out.println(bytes1[0]);
    }

}
