package org.tj.algorithms.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 001 on 16/7/1.
 */
public class MaxSonArrSum {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i<10;i++){
            list.add(i+"");
        }
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }
    }
}
