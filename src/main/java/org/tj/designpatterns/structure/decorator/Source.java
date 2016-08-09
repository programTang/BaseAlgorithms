package org.tj.designpatterns.structure.decorator;

/**
 * Created by 001 on 16/8/8.
 */
public class Source implements Sourceable{

    @Override
    public void method1() {
        System.out.println("this is the original method");
    }
}
