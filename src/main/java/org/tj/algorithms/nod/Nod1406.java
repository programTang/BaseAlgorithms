package org.tj.algorithms.nod;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by 001 on 16/7/6.
 */
public class Nod1406 {
//    public static void main(String[] args) {
//        for (int i=0;i<10000;i++){
//            if ((i&4) == i){
//                System.out.println(i);
//            }
//        }
////        System.out.println(5&7);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int N = 20;
        int f[] = new int[1000001];
        for(int i = 0;i<N;i++){
            for (int j=0;i<(i<<N);j++){
//                if (&(1<<j)){
//                    if ((~j)&(1<<j)){
                    f[j] += f[j|(1<<j)];
//                }
            }

        }
        for (int i=0;i<100001;i++){
            System.out.println(f[i]);
        }

//        Arrays.sort(arr);
//        int max = arr[n-1];
//        int arr2[] = new int[1000001];
//        for (int i = 0;i<=100000;i++){
////            int count = 0;
//            if(i<=max){
//                for (int j = 0;j<n;j++){
//                    if (arr[j]>=i && (i&arr[j]) == i){
//                        arr2[i] ++;
//                    }
//                }
//            }
//            out.println(arr2[i]);
//        }
    }
}
