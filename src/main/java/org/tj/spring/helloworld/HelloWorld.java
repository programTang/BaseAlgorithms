package org.tj.spring.helloworld;

/**
 * Created by 001 on 16/8/9.
 */
public class HelloWorld {

    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }

}
