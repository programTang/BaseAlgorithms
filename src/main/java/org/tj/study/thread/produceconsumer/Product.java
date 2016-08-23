package org.tj.study.thread.produceconsumer;

import org.tj.study.thread.ticket.one.ThreadA;

/**
 * Created by 001 on 16/8/23.
 */
public class Product {

    Storage storage = new Storage();
    final int MAX_STOARGE = 50;

    private class Storage{
        int storage = 0;
        private void produce(int num){
            this.storage+=num;
            System.out.println(Thread.currentThread().getName()+" 产生了 "+num+" , 还剩 "+storage );

        }

        private void comsume(int num){
            this.storage-=num;
            System.out.println(Thread.currentThread().getName()+" 消费了 "+num+" , 还剩 "+storage );
        }

        public int getStorage() {
            return storage;
        }

        public void setStorage(int storage) {
            this.storage = storage;
        }
    }

    public void produce(int num){
//      如果库存容量无限 直接生产  否则当前库存＋num 大于最大库存  无法生产 生产者等待
        synchronized (storage){
            while (storage.getStorage()+num>MAX_STOARGE){
                try {
                    System.out.println(Thread.currentThread().getName()+" 生产者进入等待状态，想生产: "+num+"  库存: "+storage.getStorage()+" 剩余库存"+(MAX_STOARGE - storage.getStorage()));
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.produce(num);
//            叫醒消费线程起来消费
            storage.notifyAll();
        }
    }

    public void consume(int num){
        synchronized (storage){
            while (storage.getStorage()<num){
//              库存小于消费的数量 等待
                try {
                    System.out.println(Thread.currentThread().getName()+" 消费者进入等待状态，想消费: "+num+"  库存: "+storage.getStorage());
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            消费
            storage.comsume(num);
            storage.notifyAll();
        }
    }


}
