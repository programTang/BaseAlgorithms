package org.tj.study.thread.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 001 on 16/8/24.
 */
public class DemoReadWriterLock {

    static private Map<String,Object> map = new HashMap<>();
    static private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static private Lock reader = readWriteLock.readLock();
    static private Lock writer =readWriteLock.readLock();

    static final Object get(String key){
        reader.lock();
        try {
             return map.get(key);
        }finally {
            reader.unlock();
        }
    }

    static final Object put(String key,Object object){
        writer.lock();
        try{
            map.put(key,object);
        }finally {
            writer.unlock();
        }
        return object;
    }

    static void clear(){
        writer.lock();
        try {
            map.clear();
        }finally {
            writer.unlock();
        }
    }


}
