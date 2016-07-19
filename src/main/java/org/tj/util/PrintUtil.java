package org.tj.util;

/**
 * Created by 001 on 16/7/19.
 */
public class PrintUtil {

    public static void printArray(int a[][],int n,int m){
        for (int j=0;j<n;j++){
            for (int k=0;k<m;k++){
                System.out.print(a[j][k]+"   ");
            }
            System.out.println(" ");
        }
    }
}
