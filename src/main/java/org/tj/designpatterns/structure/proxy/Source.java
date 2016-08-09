package org.tj.designpatterns.structure.proxy;

/**
 * Created by 001 on 16/8/8.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the original method");
    }
}
