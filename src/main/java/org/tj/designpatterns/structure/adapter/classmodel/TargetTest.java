package org.tj.designpatterns.structure.adapter.classmodel;

/**
 * Created by 001 on 16/8/8.
 */
public class TargetTest {

//    类的适配器模式 ，目的是将某个类的接口转换成客户期望的另一个接口表示，消除由于接口不匹配所造成的类的兼容性问题。
//    这里将source 的 method1 接口  转换成了target 的method1接口  并且 新增加了method2 接口
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

}
