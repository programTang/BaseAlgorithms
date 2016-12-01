package org.tj.study.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 001 on 16/11/22.
 */
public class FinalTest {

    static class JsonMap<K,V> extends HashMap<K,V>{
        @Override
        public String toString() {
            Iterator<Entry<K,V>> i = entrySet().iterator();
            if (! i.hasNext())
                return "{}";

            StringBuilder sb = new StringBuilder();
            sb.append('{');
            for (;;) {
                Entry<K,V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                sb.append("\"");
                sb.append(key   == this ? "(this Map)" : key);
                sb.append("\":\"");
                sb.append(value == this ? "(this Map)" : value);
                sb.append("\"");
                if (! i.hasNext())
                    return sb.append('}').toString();
                sb.append(',').append(' ');
            }
        }
    }

    public static void main(String[] args) {
        final int i = 10;
//        System.out.println(i++);
        final int [] ints = {1,3,4,5};
        System.out.println(ints[2]);
        ints[2] = 12;
        System.out.println(ints[2]);
        Map<String,String> map = new JsonMap<>();
        map.put("aasda","asdasda");
        map.put("aasd234a","34");
        map.put("35","嘻嘻");
        map.put("阿萨德撒","阿萨德");
        System.out.println(map);

    }
}
