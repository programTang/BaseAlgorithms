package org.tj.oop;

/**
 * Created by 001 on 16/7/27.
 */
public class Bird extends Animal{

    @Override
    public void breathe() {
        System.out.println("bird sing");
    }

    public void fly() {
        System.out.println("Bird Fly");
    }

    public String getClassName(){
        return super.getClass().getName();
    }

}
