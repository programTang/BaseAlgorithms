package org.tj.designpatterns.structure.decorator;

/**
 * Created by 001 on 16/8/8.
 */
public class Decorator implements Sourceable{
    private Source source;

    public Decorator(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        System.out.println("before decorator");
        source.method1();
        System.out.println("after decorator");
    }
}
