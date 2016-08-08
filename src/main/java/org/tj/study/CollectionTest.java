package org.tj.study;

import java.util.HashMap;

/**
 * Created by 001 on 16/7/26.
 */
public class CollectionTest {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"haha");
        map.put(null,"aa");
//        map.put(null,"haha");
        System.out.println(map.get(null));
        String a = "ss";
        a.hashCode();
    }

}
