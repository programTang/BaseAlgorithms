package org.tj.algorithms.nod;

import java.io.IOException;
import java.util.*;

/**
 * Created by 001 on 16/7/19.
 */
public class Nod1354 {

    public static void main(String[] args) throws IOException {
        List<Integer> sums = new ArrayList<>();
        Scanner in = new Scanner(System.in);;
        int N = in.nextInt();
        int K = in.nextInt();
//        sums.add(1);
        for(int i=0;i<N; i++){
//            Set<Integer> tempSet = new HashSet<>();
            int j = in.nextInt();
            Object[] array = sums.toArray();
            for (Object sum:array){
                sums.add((int)sum*j);
            }
            sums.add(j);
        }
        System.out.println(sums);
        int count = 0;
        for (int k:sums){
            if (k == K){
                count++;
            }
        }
        System.out.println(count);
    }
}
