package org.tj.nod;

import java.io.*;

/**
 * Created by 001 on 16/6/24.
 */
public class Nod1130 {

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
//
//        int num = Integer.parseInt(reader.readLine());
//        long []arr = new long[num];
//        for (int i = 0;i<num;i++){
//            arr[i] = Long.parseLong(reader.readLine());
//            writer.write((long)Math.ceil(Math.log10(stirling(arr[i]))+1)+"\r\n");
//        }
//
//        for (int i=0;i<num;i++){
//            writer.write(Math.log10(stirling(arr[i]))+1+"\r\n");
//        }
//        writer.flush();
        System.out.println(stirling(10000));
    }

    public static  double stirling(long n){
        if (n == 0){
            return 0;
        }
        return (Math.sqrt(2*Math.PI*n))*(Math.pow(n/Math.E,n));
    }
}