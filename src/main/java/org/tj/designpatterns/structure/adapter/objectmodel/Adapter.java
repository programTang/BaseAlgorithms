package org.tj.designpatterns.structure.adapter.objectmodel;

import org.tj.designpatterns.structure.adapter.classmodel.Source;
import org.tj.designpatterns.structure.adapter.classmodel.Targetable;

/**
 * Created by 001 on 16/8/8.
 */
public class Adapter implements Targetable {

    private Source source;

    public Adapter(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the new method");
    }
}
