package org.tj.nod;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author avx
 */
public class Nod10952 {
    private static BigInteger P2(int vN) {
        BigInteger tResult = BigInteger.valueOf(2).pow(vN);
        return tResult;
    }

    private static BigInteger P1(BigInteger vN, int vP) {
        return vN.pow(vP);
    }

    private static BigInteger F3(int vN, int vM) {
        BigInteger tResult = BigInteger.ONE;
        for(int i=vM+2; i<=vN; i+=2)
            tResult = tResult.multiply(BigInteger.valueOf(i));

        return tResult;
    }

    private static BigInteger F2(int vN) {
        BigInteger tResult = BigInteger.ONE;
        for(int i=1; i<=vN; i+=2)
            tResult = tResult.multiply(BigInteger.valueOf(i));

        return tResult;
    }

    private static BigInteger F1(int vN) {
        BigInteger tResult = BigInteger.ONE;
        for(int i=1; i<=vN; ++i)
            tResult = tResult.multiply(BigInteger.valueOf(i));

        return tResult;
    }

    private static BigInteger Factorial(int vN) {
        if(100 >= vN)
            return F1(vN);

        int					tP		= 0;
        int					tN		= vN;
        int					tIndex	= 0;
        ArrayList<Integer>	tArray	= new ArrayList<>();
        while(tN > 100) {
            if(0 == tN % 2)
                tArray.add(tIndex++, tN - 1);
            else
                tArray.add(tIndex++, tN);

            tN /= 2;
            tP += tN;
        }

        int			tCount	= tArray.size();
        BigInteger	tResult	= BigInteger.ONE;
        for(int i=0; i<tCount-1; ++i) {
            int j		= i + 1;
            int	tTempN	= tArray.get(i).intValue();
            int	tTempM	= tArray.get(j).intValue();
            tResult		= tResult.multiply(P1(F3(tTempN, tTempM), j));
        }

        tResult = tResult.multiply(F1(tN).multiply(P2(tP)));
        tResult = tResult.multiply(P1(F2(tArray.get(tCount-1).intValue()), tCount));
        return tResult;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner	tCin    = new Scanner(new InputStreamReader(System.in));
        int		tN		= tCin.nextInt();
        String	tResult	= Factorial(tN).toString();
        int		tLength	= tResult.length();
        int		tCount	= tLength / 1000;
        int		tIndex	= 0;
        for(int i=0; i<tCount; ++i) {
            int tTemp = tIndex + 1000;
            System.out.println(tResult.substring(tIndex, tTemp));
            tIndex = tTemp;
        }

        System.out.println(tResult.substring(tIndex));
    }
}