package org.tj.nod;

import org.tj.util.PrintUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 001 on 16/7/19.
 */
public class Prim {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in), 1 << 16);
        String NM[] = reader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int [][]a = new int[N+1][N+1];
        for (int i = 0 ;i<M; i++){
            String[] ddl = reader.readLine().split(" ");
            a[Integer.parseInt(ddl[0])][Integer.parseInt(ddl[1])] = Integer.parseInt(ddl[2]);
            a[Integer.parseInt(ddl[1])][Integer.parseInt(ddl[0])] = Integer.parseInt(ddl[2]);
        }
        PrintUtil.printArray(a,N+1,N+1);
        System.out.println(solve(a,1,N,N,0));

    }

    static int solve(int a[][],int i,int N,int count,int sum){
        if (count >0){
            int min =0,j=1,d=0;
            for (;j<=N;j++){
                if (a[i][j]!=0){
                    min = a[i][j];
                    d = j;
                    break;
                }
            }
//            System.out.println(i);
//            System.out.println(j);
            for (;j<=N;j++){
//                System.out.println(i+"  "+j+"  "+min);
                if (a[i][j]<min && a[i][j]!= 0 ){
                    min = a[i][j];
                    d = j;
                }
            }
            a[i][d]=0;
            a[d][i]=0;
            for(int k=1;k<=N;k++){
                a[k][d] = 0;
            }
//            System.out.println(min);
//            System.out.println(sum);
            sum += min;
            count--;
            System.out.println("点一："+i+"   点二： "+d+"   最短距离："+min+"   总长度："+sum);
            solve(a, d, N, count, sum);
        }
        return sum;
    }
}
