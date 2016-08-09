package org.tj.designpatterns.structure.proxy;

/**
 * Created by 001 on 16/8/8.
 */
public class Proxy implements Sourceable{
    private Source source;

    public Proxy(){
        this.source = new Source();
    }


    @Override
    public void method() {
        beforeProxy();
        source.method();
        afterProxy();
    }

    public void beforeProxy(){
        System.out.println("before proxy");
    }

    public void afterProxy(){
        System.out.println("after proxy");
    }

}
