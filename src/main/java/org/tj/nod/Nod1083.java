package org.tj.nod;

import org.tj.datastruct.stack.Stack;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 001 on 16/7/11.
 */
public class Nod1083 {
    public static void main(String[] args) {
        String a = "1234";
        Stack<String> stack = new Stack<>();
        stack.push(a.substring(0,1));
        for (int i=1;i<a.length();i++){
            String insert = getIndex(a,i+1);
            Set<String> set = new HashSet<>();
            while (stack.getSize() != 0){
                String t = stack.pop();
                for (int j=0;j<i;j++){
                    set.add(insertIndex(t,insert,j));
                }
            }
            for (String s:set){
                stack.push(s);
            }
        }
        while (stack.getSize()!=0){
            System.out.println(stack.pop());
        }
    }
    static String getIndex(String a,int n){
        return a.substring(n-1,n);
    }
    static String insertIndex(String a,String insert,int n){
        return a.substring(0,n)+insert+a.substring(n);
    }
}
