package org.tj.nod;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 001 on 16/7/5.
 */
public class Nod10953 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);

        String ss;
        int n;
        n = in.nextInt();

        ss = solve(1, n).toString();
        for (int i = 0; i < ss.length(); i++) {
            if ((i != 0) && (i%1000 == 0)) out.println();
            out.print(ss.charAt(i));
        }

    }

    static BigInteger solve(int first, int len) {
        if (len == 1) return BigInteger.valueOf(first);
        int mid = len/2;
        return solve(first, mid).multiply(solve(first+mid, len-mid));
    }
}


