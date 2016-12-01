package org.tj.study.spring.beans;

import java.io.File;

/**
 * Created by 001 on 16/8/9.
 */
public class BeanTest {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = UiApplicationContextUtils
        File file = new File("./");
        System.out.println(file.getAbsoluteFile());
//        BeanFactory
    }
}
