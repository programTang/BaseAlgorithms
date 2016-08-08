package org.tj.designpatterns.creater.factory.simplefactory;

/**
 * Created by 001 on 16/8/7.
 */
public class SenderFactory {

//    简单工厂  所有的产品用一个方法 根据传入的参数不同创建
    Sender produceSender(SendProducter sender){
       switch (sender){
           case Mail:
               return new MailSender();
           case Message:
               return new MessageSender();
           default:
               System.out.println("wrong product");
               return null;
       }
    }

//    工厂方法模式 不同的产品用不同的工厂方法 例如produceMailSender 和 produceMessageSender
//  但是每次增加新产品还要增加工厂类的工厂方法

//    静态工厂模式  不同的产品用不同的工厂类来创建 他们都继承于一个静态的工厂类，这样每增加一个产品
//  只需要增加一个工厂类即可，不用改变原来的代码
}
