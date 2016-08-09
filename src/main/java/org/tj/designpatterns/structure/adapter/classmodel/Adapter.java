package org.tj.designpatterns.structure.adapter.classmodel;

/**
 * Created by 001 on 16/8/8.
 */
public class Adapter extends Source implements Targetable{


    @Override
    public void method2() {
        System.out.println("this is the new method");
    }
}
