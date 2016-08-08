package org.tj.oop;

/**
 * Created by 001 on 16/7/28.
 */
public class Test {

    static void breath(Animal animal){
        animal.breathe();
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.breathe();

        Animal animal = new Bird();
        animal.breathe();

        Cat cat = (Cat) animal;

//        Cat cat = (Cat) new Animal(); //这样向下转型会出错
        cat.breathe();
//        cat.run();
    }
}
