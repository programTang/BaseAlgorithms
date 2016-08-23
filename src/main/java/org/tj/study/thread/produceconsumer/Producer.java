package org.tj.study.thread.produceconsumer;

/**
 * Created by 001 on 16/8/23.
 */
public class Producer implements Runnable{

    Product product;
    int num;

    public Producer(Product product,int num){
        this.product = product;
        this.num = num;
    }

    @Override
    public void run() {
        product.produce(num);
    }
}
