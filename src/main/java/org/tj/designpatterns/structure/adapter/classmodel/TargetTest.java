package org.tj.designpatterns.structure.adapter.classmodel;

/**
 * Created by 001 on 16/8/8.
 */
public class TargetTest {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.method1();
        target.method2();
    }

}
