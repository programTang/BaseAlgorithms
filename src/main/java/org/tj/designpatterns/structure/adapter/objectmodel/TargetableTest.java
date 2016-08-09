package org.tj.designpatterns.structure.adapter.objectmodel;

import org.tj.designpatterns.structure.adapter.classmodel.Source;
import org.tj.designpatterns.structure.adapter.classmodel.Targetable;

/**
 * Created by 001 on 16/8/8.
 */
public class TargetableTest {

//    针对对象的
    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Adapter(source);
        targetable.method1();
        targetable.method2();
    }
}
