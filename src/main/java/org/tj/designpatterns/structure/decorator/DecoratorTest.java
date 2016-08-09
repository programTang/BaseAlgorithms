package org.tj.designpatterns.structure.decorator;

/**
 * Created by 001 on 16/8/8.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Source source = new Source();
        Sourceable sourceable = new Decorator(source);
        sourceable.method1();
    }
}
