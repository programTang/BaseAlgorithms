package org.tj.designpatterns.structure.proxy;

/**
 * Created by 001 on 16/8/8.
 */
public class ProxyTest {

    public static void main(String[] args) {

        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
