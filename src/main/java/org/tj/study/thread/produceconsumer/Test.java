package org.tj.study.thread.produceconsumer;

/**
 * Created by 001 on 16/8/23.
 */
public class Test {

    public static void main(String[] args) {
        Product product = new Product();

//        Producer producer1 = new Producer(product,10);
//        Producer producer2 = new Producer(product,20);
//        Producer producer3 = new Producer(product,30);

//        Consumer consumer1 = new Consumer(product,30);
//        Consumer consumer2 = new Consumer(product,20);
//        Consumer consumer3 = new Consumer(product,10);

        Thread producer1 = new Thread(new Producer(product,10),"producer1");
        Thread producer2 = new Thread(new Producer(product,20),"producer2");
        Thread producer3 = new Thread(new Producer(product,30),"producer3");

        Thread consumer1 = new Thread(new Consumer(product,30),"consumer1");
        Thread consumer2 = new Thread(new Consumer(product,20),"consumer2");
        Thread consumer3 = new Thread(new Consumer(product,10),"consumer3");


        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

    }
}
