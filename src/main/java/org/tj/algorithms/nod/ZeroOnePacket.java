package org.tj.algorithms.nod;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 001 on 16/7/14.
 */
public class ZeroOnePacket {

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
//        int v = in.nextInt();//容量
//        int n = in.nextInt(); //数量
//        int []c = new int[n];//价值
//        int []w = new int[n];//重量
//        for (int i=0;i<n;i++){
//            c[i] = in.nextInt();
//        }
//        for (int i=0;i<n;i++){
//            w[i] = in.nextInt();
//        }
//
//        int [][]f = new int[n][v];
        int v = 10,n = 5;
        int [] c = {0,6,3,5,4,6};
        int [] w = {0,2,2,6,5,4};
        int [][]f = new int[n+1][v+1];

//        for(int k=0; k<=v; k++) f[0][k] = 0;
        //初始化二维表中的第一列
//        for(int k=0; k<=n; k++) f[k][0] = 0;

//        printArray(f,n+1,v+1);

        int i,j = 0;
        for (i=1;i<=n;i++){
            for (j=1;j<=v;j++){
                f[i][j] = f[i-1][j];
                if (w[i]<=j){
                    f[i][j] = getMax(f[i-1][j],f[i-1][j-w[i]]+c[i]);
                }
            }
        }
//用来存储每个物品是否放入背包最大值
        int []f1 = new int[n];
        for (i=1;i<=n;i++){
//            f1[i]
            for (j=1;j<=v;j++){
                f[i][j] = f[i-1][j];
                if (w[i]<=j){

                    f[i][j] = getMax(f[i-1][j],f[i-1][j-w[i]]+c[i]);
                }
            }
        }


        int maxValue = f[n][v];
        int remainW = v;
        System.out.println("maxValue:"+maxValue);
        for (int t = n;t>0;t--){
            if (w[t]<remainW){
                if (f[t][remainW] == (f[t-1][remainW-w[t]]+c[t]) ){
                    System.out.println(t+" 被选择");
                    remainW = remainW - w[t];
                }
            }
        }

        printArray(f,n,v);
    }

//    static int zeroOnePackt(int cost,int value){
//
//    }

    static int getMax(int a,int b){
        return a>=b?a:b;
    }

    static void printArray(int[][] array,int a,int b){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                System.out.print("  "+array[i][j]);
            }
            System.out.println("");
        }
    }

}
