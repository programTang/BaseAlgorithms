package org.tj.java8.gc;

/**
 * Created by 001 on 16/8/15.
 */
public class GCRootsTest {

    public static GCRootsTest gcRootsTest = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method is executed");
        GCRootsTest.gcRootsTest = this;
    }

    public static void main(String[] args) throws InterruptedException {
//        第一次gc 在finalize 中 将this指针赋值给某个类变量或者对象的成员变量来拯救了自己，所以没有被回收
//        并且将这个对象放置在了 F-Queue 队列中，
        gcRootsTest = new GCRootsTest();
        gcRootsTest = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(gcRootsTest);


        gcRootsTest = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(gcRootsTest);

    }
}
