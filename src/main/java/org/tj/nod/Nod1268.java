package org.tj.nod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 001 on 16/7/18.
 */
public class Nod1268 {

    public static void main(String[] args) throws IOException {
        Set<Integer> sums = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in), 1 << 16);
        String NK[] = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        sums.add(0);
        for(int i=0;i<N; i++){
//            Set<Integer> tempSet = new HashSet<>();
            Object[] array = sums.toArray();
            int j = reader.read();
           for (Object sum:array){
              sums.add((int)sum+j);
           }
        }
        System.out.println(sums.contains(K)?"YES":"NO");
    }
}
