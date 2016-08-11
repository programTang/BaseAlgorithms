package org.tj.nod;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 001 on 16/8/11.
 */
public class Nod1384 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        String str = in.next();
        char[] chars = str.toCharArray();

        Set<String> set = new TreeSet<String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;
                return str1.compareTo(str2);
            }
        });
        set.add(chars[0]+"");
        for (int i=1;i<chars.length;i++){
            Set<String> set1 = new TreeSet<>();
            Object[] strings =  set.toArray();
            for (Object str1 : strings){
                set1.addAll(putStrs((String)str1,chars[i]));
            }
            set = set1;
        }

            Object[] strings =  set.toArray();
        for (Object string:strings){
            out.println(string);
        }
        out.flush();
    }

    public static Set<String> putStrs(String str,char a){
        Set<String> set = new TreeSet<>();
        int length = str.length();
        for (int i=0;i<=length;i++){
            String newStr = putChar(str,i,a);
            set.add(newStr);
        }
        return set;
    }

    public static String putChar(String str,int i,char a){
        return str.substring(0,i)+a+str.substring(i,str.length());
    }

}
