package org.tj.nod;

import java.util.Arrays;
/**
 * 背包问题
 * @author 赵学庆 java2000.net
 *
 */
public class T {
    /**
     * @param value 价值
     * @param weight 重量
     * @param capicity 背包容量
     * @param m 表示只有w[i],w[i+1]...w[n]这些物品时,背包容量为j时的最大价值
     */
    public static void knapsack(int[] value, int[] weight, int capicity, int[][] m) {
        // 数量
        int n = value.length - 1;
        // 最后一个重量-1和容量的更小的一个
        int jMax = Math.min(weight[n] - 1, capicity);
        // 将最后一个数组的前部分清空。
        for (int j = 0; j <= jMax; j++)
            m[n][j] = 0; // 当w[n]>j 有 m[n][j]=0
        showArray(m);
        // 后半部分设置为此物品的价值
        // m[n][j] 表示只有w[n]物品，背包的容量为j时的最大价值
        for (int j = weight[n]; j <= capicity; j++)
            m[n][j] = value[n]; // 当w[n]<=j 有m[n][j]=v[n]
        showArray(m);
        // 递规调用求出m[][]其它值，直到求出m[0][c]
        for (int i = n - 1; i >= 1; i--) {
            jMax = Math.min(weight[i] - 1, capicity);
            System.out.println(jMax);
            for (int k = 0; k <= jMax; k++)
                m[i][k] = m[i + 1][k];


            for (int h = weight[i]; h <= capicity; h++) {
                System.out.println(m[i+1][h]+" / "+ m[i + 1][h - weight[i]]+" + " +value[i]+"("+h+","+weight[i]+","+value[i]+")");
                m[i][h] = Math.max(m[i + 1][h], m[i + 1][h - weight[i]] + value[i]);
            }
            showArray(m);
        }
        m[0][capicity] = m[1][capicity];
        if (capicity >= weight[0])
            m[0][capicity] = Math.max(m[0][capicity], m[1][capicity - weight[0]] + value[0]);
        System.out.println("bestw =" + m[0][capicity]);
    }
    public static void showArray(int[][] m) {
        for (int[] a : m) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-------------------------------------------");
    }
    public static void traceback(int[][] m, int[] w, int c, int[] x) {// 根据最优值求出最优解
        int n = w.length - 1;
        for (int i = 0; i < n; i++)
            if (m[i][c] == m[i + 1][c])
                x[i] = 0;
            else {
                x[i] = 1;
                c -= w[i];
            }
        x[n] = (m[n][c] > 0) ? 1 : 0;
    }
    public static void main(String[] args) {
        // 测试
        int[] ww = { 8,5,4,3 };
        int[] vv = { 10,7,5,4 };
        int[][] mm = new int[4][13];
        knapsack(vv, ww, 12, mm);
        int[] xx = new int[ww.length];
        traceback(mm, ww, 12, xx);
        for (int i = 0; i < xx.length; i++)
            System.out.println(xx[i]);
    }
}