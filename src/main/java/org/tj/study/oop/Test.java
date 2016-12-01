package org.tj.study.oop;

import org.tj.study.oop.innerclass.OutClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 001 on 16/7/28.
 */
public class Test {


    static void breath(Animal animal){
        animal.breathe();
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        OutClass.InnerClass innerClass = new OutClass().new InnerClass();
//        System.out.println(innerClass.);


//        Bird bird = new Bird();
//
//        System.out.println(bird.getClassName());

//        bird.breathe();

//        Animal animal = new Bird();
//        animal.breathe();
////        System.out.println(animal.getClass().getName());
//        List<Animal> list = new ArrayList();
////        list.add(new Bird());
//        list.add(new Animal() {
//            @Override
//            public void breathe() {
//                System.out.println("xixi");
//            }
//        });
//        Bird animal = (Bird) list.get(0);
//        bird.breathe();
//        Class clazz = bird.getClass();
//        Class clazz2 = int[].class;
//        Class clazz3 = int.class;
//        System.out.println(clazz.getClassLoader());
//        System.out.println(clazz2.getClassLoader());
//        System.out.println(clazz3.getClassLoader());
//        Class clazz = Animal.class;
//        Class clazz1 = Class.forName("org.tj.study.oop.Animal");

//        Class clazz1 = Animal.class;
//        Class clazz = Animal.class;
//        System.out.println(animal.getClass().getName());
//        Cat cat = (Cat) animal;
            Class<?> clazz = int.class;
            clazz = double.class;
        Map<String,String> map = new HashMap<>();
//        clazz.get
//        clazz.getMethod("")
            System.out.println(clazz.getName());


//        Cat cat = (Cat) new Animal(); //这样向下转型会出错
//        cat.breathe();
//        cat.run();
    }
}
