package org.tj.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 001 on 16/8/17.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(e -> e = e + "xxx");
        System.out.println(list);
//        Runnable

//        List<String> list = new ArrayList<>();
//        list.forEach( );
    }
}
